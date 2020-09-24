package geektime.spring.springbucks.jpademo.repository;

import geektime.spring.springbucks.jpademo.model.CoffeeOrder;

import java.util.List;

public interface CoffeeOrderRepository extends BaseRepository<CoffeeOrder, Long> {
    List<CoffeeOrder> findByCustomerOrderById(String customer);
    List<CoffeeOrder> findByItems_Name(String name);
}
