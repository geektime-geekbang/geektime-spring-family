package geektime.spring.data.reactive.mongodbdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coffee {
    private String id;
    private String name;
    private Money price;
    private Date createTime;
    private Date updateTime;
}
