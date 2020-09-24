package geektime.spring.cloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardDemoApplication.class, args);
	}

}
