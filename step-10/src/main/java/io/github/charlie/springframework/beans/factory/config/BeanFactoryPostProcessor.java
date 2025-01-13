package io.github.charlie.springframework.beans.factory.config;


import io.github.charlie.springframework.beans.BeansException;
import io.github.charlie.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/9
 * @Description: TODO
 */
public interface BeanFactoryPostProcessor {
    // BeanDefinition加载完成后，实例Bean对象实例化之前，提供修改BeanDefinition属性的机制方法
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
