package geektime.spring.springbucks.repository;

import geektime.spring.springbucks.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
