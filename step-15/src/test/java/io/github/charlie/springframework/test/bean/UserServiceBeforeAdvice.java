package io.github.charlie.springframework.test.bean;

import io.github.charlie.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/14
 * @Description: TODO
 */
public class UserServiceBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法：" + method.getName());
    }

}
