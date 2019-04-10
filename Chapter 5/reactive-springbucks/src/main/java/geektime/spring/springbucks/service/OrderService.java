package geektime.spring.springbucks.service;

import geektime.spring.springbucks.model.CoffeeOrder;
import geektime.spring.springbucks.repository.CoffeeOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.function.DatabaseClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OrderService {
    @Autowired
    private CoffeeOrderRepository repository;
    @Autowired
    private DatabaseClient client;

    public Mono<Long> create(CoffeeOrder order) {
        return repository.save(order);
    }
}
