package io.github.charlie.springframework.beans.factory.config;

/**
 * 单例注册
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject); // 书上有，但是源码没有的
}
