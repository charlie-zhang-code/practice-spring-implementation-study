package io.github.charlie.springframework.beans.factory.support;

import io.github.charlie.springframework.beans.BeansException;
import io.github.charlie.springframework.beans.factory.BeanFactory;
import io.github.charlie.springframework.beans.factory.config.BeanDefinition;

/**
 * 注册接口
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String beanName) throws BeansException {
        Object bean = getSingleton(beanName);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
