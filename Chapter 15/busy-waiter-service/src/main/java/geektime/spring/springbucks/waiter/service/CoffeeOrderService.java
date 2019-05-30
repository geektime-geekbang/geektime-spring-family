package geektime.spring.springbucks.waiter.service;

import geektime.spring.springbucks.waiter.integration.Barista;
import geektime.spring.springbucks.waiter.model.Coffee;
import geektime.spring.springbucks.waiter.model.CoffeeOrder;
import geektime.spring.springbucks.waiter.model.OrderState;
import geektime.spring.springbucks.waiter.repository.CoffeeOrderRepository;
import geektime.spring.springbucks.waiter.support.OrderProperties;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
@Slf4j
public class CoffeeOrderService implements MeterBinder {
    @Autowired
    private CoffeeOrderRepository orderRepository;
    @Autowired
    private OrderProperties orderProperties;
    @Autowired
    private Barista barista;

    private String waiterId = UUID.randomUUID().toString();

    private Counter orderCounter = null;

    public CoffeeOrder get(Long id) {
        return orderRepository.getOne(id);
    }

    public CoffeeOrder createOrder(String customer, Coffee...coffee) {
        CoffeeOrder order = CoffeeOrder.builder()
                .customer(customer)
                .items(new ArrayList<>(Arrays.asList(coffee)))
                .discount(orderProperties.getDiscount())
                .total(calcTotal(coffee))
                .state(OrderState.INIT)
                .waiter(orderProperties.getWaiterPrefix() + waiterId)
                .build();
        CoffeeOrder saved = orderRepository.save(order);
        log.info("New Order: {}", saved);
        orderCounter.increment();
        return saved;
    }

    public boolean updateState(CoffeeOrder order, OrderState state) {
        if (order == null) {
            log.warn("Can not find order.");
            return false;
        }
        if (state.compareTo(order.getState()) <= 0) {
            log.warn("Wrong State order: {}, {}", state, order.getState());
            return false;
        }
        order.setState(state);
        orderRepository.save(order);
        log.info("Updated Order: {}", order);
        if (state == OrderState.PAID) {
            // 有返回值，如果要关注发送结果，则判断返回值
            // 一般消息体不会这么简单
            barista.newOrders().send(MessageBuilder.withPayload(order.getId()).build());
        }
        return true;
    }

    @Override
    public void bindTo(MeterRegistry meterRegistry) {
        this.orderCounter = meterRegistry.counter("order.count");
    }

    private Money calcTotal(Coffee...coffee) {
        List<Money> items = Stream.of(coffee).map(c -> c.getPrice())
                .collect(Collectors.toList());
        return Money.total(items).multipliedBy(orderProperties.getDiscount())
                .dividedBy(100, RoundingMode.HALF_UP);
    }
}
