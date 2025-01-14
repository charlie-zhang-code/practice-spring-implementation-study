package io.github.charlie.springframework.test;

import io.github.charlie.springframework.aop.AdvisedSupport;
import io.github.charlie.springframework.aop.MethodMatcher;
import io.github.charlie.springframework.aop.TargetSource;
import io.github.charlie.springframework.aop.aspectj.AspectJExpressionPointcut;
import io.github.charlie.springframework.aop.framework.Cglib2AopProxy;
import io.github.charlie.springframework.aop.framework.JdkDynamicAopProxy;
import io.github.charlie.springframework.context.support.ClassPathXmlApplicationContext;
import io.github.charlie.springframework.test.bean.IUserService;
import io.github.charlie.springframework.test.bean.UserService;
import io.github.charlie.springframework.test.bean.UserServiceInterceptor;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ApiTest {
    @Test
    public void test_proxy_method() {
       // 目标
//        Object targetObj = new UserService();
//
//        // APO daili
//        IUserService proxy = (IUserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), targetObj.getClass().getInterfaces(), new InvocationHandler() {
//            MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* io.github.charlie.springframework.test.bean.IUserService.*(..))");
//
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//
//            }
//        });
    }

    @Test
    public void test_aop() throws NoSuchMethodException  {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* io.github.charlie.springframework.test.bean.UserService.*(..))");
        Class<UserService> clazz = UserService.class;
        Method method = clazz.getDeclaredMethod("queryUserInfo");

        System.out.println(pointcut.matches(clazz));
        System.out.println(pointcut.matches(method, clazz));
    }

    @Test
    public void test_dynamic() {
        // 目标对象（被代理对象）
        IUserService userService = new UserService();

        // 组装代理
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* io.github.charlie.springframework.test.bean.IUserService.*(..))"));

        // 代理对象
        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        System.out.println("测试结果：" + proxy_jdk.queryUserInfo());

        // 代理对象
        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        System.out.println("测试结果：" + proxy_cglib.register("花花"));
    }
}
