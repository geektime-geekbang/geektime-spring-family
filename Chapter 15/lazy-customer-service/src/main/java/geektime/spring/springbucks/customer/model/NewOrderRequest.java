package geektime.spring.springbucks.customer.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@Setter
public class NewOrderRequest {
    private String customer;
    private List<String> items;
}
