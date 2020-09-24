package geektime.spring.springbucks.jpademo;

import geektime.spring.springbucks.jpademo.model.Coffee;
import geektime.spring.springbucks.jpademo.model.CoffeeOrder;
import geektime.spring.springbucks.jpademo.model.OrderState;
import geektime.spring.springbucks.jpademo.repository.CoffeeOrderRepository;
import geektime.spring.springbucks.jpademo.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
@Slf4j
public class JpaDemoApplication implements ApplicationRunner {
	@Autowired
	private CoffeeRepository coffeeRepository;
	@Autowired
	private CoffeeOrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
		initOrders();
		findOrders();
	}

	private void initOrders() {
		Coffee latte = Coffee.builder().name("latte")
				.price(Money.of(CurrencyUnit.of("CNY"), 30.0))
				.build();
		coffeeRepository.save(latte);
		log.info("Coffee: {}", latte);

		Coffee espresso = Coffee.builder().name("espresso")
				.price(Money.of(CurrencyUnit.of("CNY"), 20.0))
				.build();
		coffeeRepository.save(espresso);
		log.info("Coffee: {}", espresso);

		CoffeeOrder order = CoffeeOrder.builder()
				.customer("Li Lei")
				.items(Collections.singletonList(espresso))
				.state(OrderState.INIT)
				.build();
		orderRepository.save(order);
		log.info("Order: {}", order);

		order = CoffeeOrder.builder()
				.customer("Li Lei")
				.items(Arrays.asList(espresso, latte))
				.state(OrderState.INIT)
				.build();
		orderRepository.save(order);
		log.info("Order: {}", order);
	}

	private void findOrders() {
		coffeeRepository
				.findAll(Sort.by(Sort.Direction.DESC, "id"))
				.forEach(c -> log.info("Loading {}", c));

		List<CoffeeOrder> list = orderRepository.findTop3ByOrderByUpdateTimeDescIdAsc();
		log.info("findTop3ByOrderByUpdateTimeDescIdAsc: {}", getJoinedOrderId(list));

		list = orderRepository.findByCustomerOrderById("Li Lei");
		log.info("findByCustomerOrderById: {}", getJoinedOrderId(list));

		// 不开启事务会因为没Session而报LazyInitializationException
		list.forEach(o -> {
			log.info("Order {}", o.getId());
			o.getItems().forEach(i -> log.info("  Item {}", i));
		});

		list = orderRepository.findByItems_Name("latte");
		log.info("findByItems_Name: {}", getJoinedOrderId(list));
	}

	private String getJoinedOrderId(List<CoffeeOrder> list) {
		return list.stream().map(o -> o.getId().toString())
				.collect(Collectors.joining(","));
	}
}

