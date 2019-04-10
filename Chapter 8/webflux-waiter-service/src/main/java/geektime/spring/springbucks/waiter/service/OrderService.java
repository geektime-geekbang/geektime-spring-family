package geektime.spring.springbucks.waiter.service;

import geektime.spring.springbucks.waiter.model.CoffeeOrder;
import geektime.spring.springbucks.waiter.model.OrderState;
import geektime.spring.springbucks.waiter.repository.CoffeeOrderRepository;
import geektime.spring.springbucks.waiter.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private CoffeeOrderRepository orderRepository;
    @Autowired
    private CoffeeRepository coffeeRepository;

    public Mono<CoffeeOrder> getById(Long id) {
        return orderRepository.get(id);
    }

    public Mono<Long> create(String customer, List<String> items) {
        return Flux.fromStream(items.stream())
                .flatMap(n -> coffeeRepository.findByName(n))
                .collectList()
                .flatMap(l ->
                        orderRepository.save(CoffeeOrder.builder()
                                .customer(customer)
                                .items(l)
                                .state(OrderState.INIT)
                                .createTime(new Date())
                                .updateTime(new Date())
                                .build())
                );
    }
}
