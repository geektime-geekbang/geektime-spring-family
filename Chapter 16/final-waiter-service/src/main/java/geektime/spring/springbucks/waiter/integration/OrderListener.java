package geektime.spring.springbucks.waiter.integration;

import geektime.spring.springbucks.waiter.model.CoffeeOrder;
import geektime.spring.springbucks.waiter.service.CoffeeOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderListener {
    @Autowired
    private Customer customer;
    @Autowired
    private CoffeeOrderService orderService;

    @StreamListener(Barista.FINISHED_ORDERS)
    public void listenFinishedOrders(Long id) {
        log.info("We've finished an order [{}].", id);
        CoffeeOrder order = orderService.get(id);
        Message<Long> message = MessageBuilder.withPayload(id)
                .setHeader("customer", order.getCustomer())
                .build();
        log.info("Notify the customer: {}", order.getCustomer());
        customer.notification().send(message);
    }
}
