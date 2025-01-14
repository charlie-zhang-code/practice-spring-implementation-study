package io.github.charlie.springframework.aop;

import java.lang.reflect.Method;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/14
 * @Description: 定义类匹配类，用于切点找到给定的接口和目标类
 */
public interface MethodMatcher {
    boolean matches(Method method, Class<?> targetClass);
}
