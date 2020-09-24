package geektime.spring.springbucks.waiter.repository;

import geektime.spring.springbucks.waiter.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
