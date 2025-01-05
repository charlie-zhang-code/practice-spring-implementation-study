package io.github.charlie.springframework.beans.factory.support;

import io.github.charlie.springframework.beans.factory.config.BeanDefinition;

/**
 *
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
