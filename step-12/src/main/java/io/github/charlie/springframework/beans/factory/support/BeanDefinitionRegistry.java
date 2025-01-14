package io.github.charlie.springframework.beans.factory.support;

import io.github.charlie.springframework.beans.BeansException;
import io.github.charlie.springframework.beans.factory.config.BeanDefinition;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/9
 * @Description: TODO
 */
public interface BeanDefinitionRegistry {

    //向注册表中注册Bean定义
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    //名称查询
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    //判断是否包含指定名称的Bean定义
    boolean containsBeanDefinition(String beanName);

    String[] getBeanDefinitionNames();
}
