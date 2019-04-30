package geektime.spring.springbucks.waiter.service;

import geektime.spring.springbucks.waiter.model.Coffee;
import geektime.spring.springbucks.waiter.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CoffeeService {
    @Autowired
    private CoffeeRepository coffeeRepository;

    public Mono<Coffee> findById(Long id) {
        return coffeeRepository.findById(id);
    }

    public Flux<Coffee> findAll() {
        return coffeeRepository.findAll();
    }

    public Mono<Coffee> findByName(String name) {
        return coffeeRepository.findByName(name);
    }
}
