package io.github.charlie.springframework.test;

import io.github.charlie.springframework.aop.AdvisedSupport;
import io.github.charlie.springframework.aop.TargetSource;
import io.github.charlie.springframework.aop.aspectj.AspectJExpressionPointcut;
import io.github.charlie.springframework.aop.framework.Cglib2AopProxy;
import io.github.charlie.springframework.aop.framework.JdkDynamicAopProxy;
import io.github.charlie.springframework.context.support.ClassPathXmlApplicationContext;
import io.github.charlie.springframework.test.bean.IUserService;
import io.github.charlie.springframework.test.bean.UserService;
import org.junit.Test;

import java.lang.reflect.Method;

public class ApiTest {
    @Test
    public void test_property() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService);
    }

    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

}
