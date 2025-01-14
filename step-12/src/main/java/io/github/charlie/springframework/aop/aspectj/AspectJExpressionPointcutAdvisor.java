package io.github.charlie.springframework.aop.aspectj;

import io.github.charlie.springframework.aop.Pointcut;
import io.github.charlie.springframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/14
 * @Description: TODO
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {
    // 切面
    private AspectJExpressionPointcut pointcut;
    // 具体的拦截方法
    private Advice advice;
    // 表达式
    private String expression;

    public void setExpression(String expression){
        this.expression = expression;
    }

    public void setAdvice(Advice advice){
        this.advice = advice;
    }

    @Override
    public Pointcut getPointcut() {
        if (null == pointcut) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }
}
