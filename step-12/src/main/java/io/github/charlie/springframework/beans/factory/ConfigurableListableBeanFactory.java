package io.github.charlie.springframework.beans.factory;

import io.github.charlie.springframework.beans.BeansException;
import io.github.charlie.springframework.beans.factory.config.AutowireCapableBeanFactory;
import io.github.charlie.springframework.beans.factory.config.BeanDefinition;
import io.github.charlie.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/9
 * @Description: TODO
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

}
