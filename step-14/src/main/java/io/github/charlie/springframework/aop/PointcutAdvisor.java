package io.github.charlie.springframework.aop;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/14
 * @Description: TODO
 */
public interface PointcutAdvisor extends Advisor{
    Pointcut getPointcut();
}