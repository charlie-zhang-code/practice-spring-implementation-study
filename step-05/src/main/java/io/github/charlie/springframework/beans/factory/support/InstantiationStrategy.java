package io.github.charlie.springframework.beans.factory.support;

import io.github.charlie.springframework.beans.BeansException;
import io.github.charlie.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化策略接口
 */
public interface InstantiationStrategy {
    /**
     * 实例化
     * @param beanDefinition BeanDefinition
     * @param beanName Bean名称
     * @param ctor 构造函数
     * @param args 构造函数参数
     * @return 返回实例化后的对象
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
