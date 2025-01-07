package io.github.charlie.springframework.beans.factory.config;

/**
 * 单例注册
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
