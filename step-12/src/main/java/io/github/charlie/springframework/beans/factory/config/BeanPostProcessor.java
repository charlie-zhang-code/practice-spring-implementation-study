package io.github.charlie.springframework.beans.factory.config;

import io.github.charlie.springframework.beans.BeansException;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/9
 * @Description: TODO
 */
public interface BeanPostProcessor {
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
