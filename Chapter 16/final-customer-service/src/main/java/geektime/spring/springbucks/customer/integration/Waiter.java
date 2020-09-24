package geektime.spring.springbucks.customer.integration;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Waiter {
    String NOTIFY_ORDERS = "notifyOrders";

    @Input(NOTIFY_ORDERS)
    SubscribableChannel notification();
}
