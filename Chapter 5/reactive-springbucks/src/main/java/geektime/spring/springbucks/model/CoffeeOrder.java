package geektime.spring.springbucks.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoffeeOrder implements Serializable {
    private Long id;
    private String customer;
    private OrderState state;
    private List<Coffee> items;
    private Date createTime;
    private Date updateTime;
}
