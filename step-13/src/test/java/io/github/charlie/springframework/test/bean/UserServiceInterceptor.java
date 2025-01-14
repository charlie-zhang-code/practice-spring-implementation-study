package io.github.charlie.springframework.test.bean;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/14
 * @Description: TODO
 */
public class UserServiceInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            return methodInvocation.proceed();
        } finally {
            System.out.println("监控 - Begin By AOP");
            System.out.println("方法名称：" + methodInvocation.getMethod().getName());
            System.out.println("方法耗时：" + (System.currentTimeMillis() - startTime) + "ms");
            System.out.println("监控 - End");
        }
    }
}
