package geektime.spring.springbucks.waiter.controller.request;

import geektime.spring.springbucks.waiter.model.OrderState;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderStateRequest {
    private OrderState state;
}
