package io.github.charlie.springframework.aop.framework.autoproxy;

import io.github.charlie.springframework.aop.*;
import io.github.charlie.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import io.github.charlie.springframework.aop.framework.ProxyFactory;
import io.github.charlie.springframework.beans.BeansException;
import io.github.charlie.springframework.beans.PropertyValues;
import io.github.charlie.springframework.beans.factory.BeanFactory;
import io.github.charlie.springframework.beans.factory.BeanFactoryAware;
import io.github.charlie.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import io.github.charlie.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.Collection;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/14
 * @Description: TODO
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {
    private DefaultListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {

//        if (isInfrastructureClass(beanClass)) return null;
//
//        Collection<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();
//
//        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
//            ClassFilter classFilter = advisor.getPointcut().getClassFilter();
//            if (!classFilter.matches(beanClass)) continue;
//
//            AdvisedSupport advisedSupport = new AdvisedSupport();
//
//            TargetSource targetSource = null;
//            try {
//                targetSource = new TargetSource(beanClass.getDeclaredConstructor().newInstance());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            advisedSupport.setTargetSource(targetSource);
//            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
//            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
//            advisedSupport.setProxyTargetClass(false);
//
//            return new ProxyFactory(advisedSupport).getProxy();
//
//        }

        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }

    private boolean isInfrastructureClass(Class<?> beanClass) {
        return Advice.class.isAssignableFrom(beanClass) || Pointcut.class.isAssignableFrom(beanClass) || Advisor.class.isAssignableFrom(beanClass);
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (isInfrastructureClass(bean.getClass())) return bean;

        Collection<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();

        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            ClassFilter classFilter = advisor.getPointcut().getClassFilter();
            // 过滤匹配类
            if (!classFilter.matches(bean.getClass())) continue;

            AdvisedSupport advisedSupport = new AdvisedSupport();

            TargetSource targetSource = new TargetSource(bean);
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
            advisedSupport.setProxyTargetClass(false);

            // 返回代理对象
            return new ProxyFactory(advisedSupport).getProxy();
        }

        return bean;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        return pvs;
    }





}
