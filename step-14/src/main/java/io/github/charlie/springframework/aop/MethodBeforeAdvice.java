package io.github.charlie.springframework.aop;

import java.lang.reflect.Method;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/14
 * @Description: TODO
 */
public interface MethodBeforeAdvice extends BeforeAdvice  {
    void before(Method method, Object[] args, Object target) throws Throwable;
}
