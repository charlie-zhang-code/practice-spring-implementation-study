package io.github.charlie.springframework.beans.factory;


import io.github.charlie.springframework.beans.BeansException;

public interface BeanFactory {
    // 获取Bean
    public Object getBean(String beanName) throws BeansException;

    // 获取Bean 但是 可以传入参数
    Object getBean(String name, Object... args) throws BeansException;
}
