package io.github.charlie.springframework.test;

import io.github.charlie.springframework.BeanDefinition;
import io.github.charlie.springframework.BeanFactory;
import io.github.charlie.springframework.test.bean.UserService;
import org.junit.jupiter.api.Test;

public class ApiTest {
    @Test
    public void test_BeanFactory() {
        // init the api of bean factory
        BeanFactory beanFactory = new BeanFactory();

        // register bean object
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // get bean object
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
