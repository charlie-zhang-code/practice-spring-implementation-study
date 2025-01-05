package io.github.charlie.springframework.test;

import io.github.charlie.springframework.beans.factory.config.BeanDefinition;
import io.github.charlie.springframework.beans.factory.support.DefaultListableBeanFactory;
import io.github.charlie.springframework.test.bean.UserService;
import org.junit.jupiter.api.Test;

public class ApiTest {
    @Test
    public void test_BeanFactory() {
        // init
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // register
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // get bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        // get bean again
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();
    }
}
