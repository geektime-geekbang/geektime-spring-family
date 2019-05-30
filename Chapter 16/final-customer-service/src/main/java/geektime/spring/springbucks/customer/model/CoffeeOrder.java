package geektime.spring.springbucks.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeOrder {
    private Long id;
    private String customer;
    private List<Coffee> items;
    private OrderState state;
    private String waiter;
    private String barista;
    private Integer discount;
    private Money total;
    private Date createTime;
    private Date updateTime;
}
