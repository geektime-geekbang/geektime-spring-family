package geektime.spring.springbucks.barista.repository;

import geektime.spring.springbucks.barista.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
