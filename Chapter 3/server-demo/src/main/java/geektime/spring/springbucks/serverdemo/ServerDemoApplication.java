package geektime.spring.springbucks.serverdemo;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableAdminServer //启用管理服务器 用来标识该服务器为管理服务器
public class ServerDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(ServerDemoApplication.class, args);
	}

}
