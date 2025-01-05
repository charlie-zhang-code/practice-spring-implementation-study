package io.github.charlie.springframework.test;

import io.github.charlie.springframework.beans.factory.config.BeanDefinition;
import io.github.charlie.springframework.beans.factory.support.DefaultListableBeanFactory;
import io.github.charlie.springframework.test.bean.UserService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

public class ApiTest {
    @Test
    public void test_BeanFactory() {
//        // init
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//
//        // register
//        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
//        beanFactory.registerBeanDefinition("userService", beanDefinition);
//
//        // get bean
//        UserService userService = (UserService) beanFactory.getBean("userService");
//        userService.queryUserInfo();
//
//        // get bean again
//        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
//        userService_singleton.queryUserInfo();

        // init
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // register
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // get bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

    @Test
    public void test_cglib() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new NoOp() { // 设置回调
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });

        Object object = enhancer.create(new Class[]{String.class}, new Object[]{"Charlie"});
        System.out.println(object);
    }

    @Test
    public void test_newInstance() throws IllegalAccessException, InstantiationException {
        UserService userService = UserService.class.newInstance();
        System.out.println(userService);
    }

    @Test
    public void test_constructor() throws Exception {
        Class<UserService> userServiceClass = UserService.class;
        UserService userService = userServiceClass.getDeclaredConstructor(String.class).newInstance("Charlie");
        System.out.println(userService);
    }

    @Test
    public void test_parameterTypes() throws Exception {
//        java.lang.IllegalArgumentException: wrong number of arguments
//        Class<UserService> beanClass = UserService.class;
//        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
//        Constructor<?> constructor = declaredConstructors[0]; // 获取UserService的构造函数
//        Constructor<UserService> decvlaredConstructor = beanClass.getDeclaredConstructor(constructor.getParameterTypes());
//        UserService userService = decvlaredConstructor.newInstance("Charlie");
//        System.out.println(userService);

        Class<UserService> beanClass = UserService.class;
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        Constructor<?> constructor = null;

        // 循环遍历
        for (Constructor<?> ctor : declaredConstructors) {
            if (ctor.getParameterTypes().length == 1) {
                constructor = ctor;
                break;
            }
        }

        Constructor<UserService> decvlaredConstructor = beanClass.getDeclaredConstructor(constructor.getParameterTypes());
        UserService userService = decvlaredConstructor.newInstance("Charlie");
        System.out.println(userService);
    }
}
