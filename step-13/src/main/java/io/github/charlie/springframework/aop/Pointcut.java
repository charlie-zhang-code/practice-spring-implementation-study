package io.github.charlie.springframework.aop;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/14
 * @Description: 切点表达式,定义用于获取 ClassFilter、MethodMatcher 的两个类
 */
public interface Pointcut {
    ClassFilter getClassFilter();
    MethodMatcher getMethodMatcher();
}
