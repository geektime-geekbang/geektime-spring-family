package geektime.spring.hello.greeting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.util.ClassUtils;

@Slf4j
public class GreetingBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        boolean hasClass = ClassUtils.isPresent("geektime.spring.hello.greeting.GreetingApplicationRunner",
                GreetingBeanFactoryPostProcessor.class.getClassLoader());
        if (!hasClass) {
            log.info("GreetingApplicationRunner is NOT present in CLASSPATH.");
            return;
        }

        if (beanFactory.containsBeanDefinition("greetingApplicationRunner")) {
            log.info("We already have a greetingApplicationRunner bean registered.");
            return;
        }

        register(beanFactory);
    }

    private void register(ConfigurableListableBeanFactory beanFactory) {
        if (beanFactory instanceof BeanDefinitionRegistry) {
            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(GreetingApplicationRunner.class);

            ((BeanDefinitionRegistry) beanFactory)
                    .registerBeanDefinition("greetingApplicationRunner",
                            beanDefinition);
        } else {
            beanFactory.registerSingleton("greetingApplicationRunner",
                    new GreetingApplicationRunner());
        }
    }
}
