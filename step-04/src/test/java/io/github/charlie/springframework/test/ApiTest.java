package io.github.charlie.springframework.test;

import io.github.charlie.springframework.beans.PropertyValue;
import io.github.charlie.springframework.beans.PropertyValues;
import io.github.charlie.springframework.beans.factory.config.BeanDefinition;
import io.github.charlie.springframework.beans.factory.config.BeanReference;
import io.github.charlie.springframework.beans.factory.support.DefaultListableBeanFactory;
import io.github.charlie.springframework.test.bean.UserDao;
import io.github.charlie.springframework.test.bean.UserService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

public class ApiTest {
    @Test
    public void test_BeanFactory() {
        // int
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // register
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // UserService set uid and userDao
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // reference
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // get bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
