package geektime.spring.web.foo;

import geektime.spring.web.context.TestBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @EnableAspectJAutoProxy
 * 启动aop，在aop切面增强中，在父容器
 */

@Configuration
@EnableAspectJAutoProxy
@Slf4j
public class FooConfig {

    @Bean
    public TestBean testBeanX() {
        log.info("FooConfig testBeanX.....");
        return new TestBean("foo");
    }

    @Bean
    public TestBean testBeanY() {
        log.info("FooConfig testBeanY.....");
        return new TestBean("foo");
    }

    @Bean
    public FooAspect fooAspect() {
        return new FooAspect();
    }
}
