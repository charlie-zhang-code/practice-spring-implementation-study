package io.github.charlie.springframework.beans.factory;


import io.github.charlie.springframework.beans.BeansException;

public interface BeanFactory {
    // 获取Bean
    public Object getBean(String beanName) throws BeansException;
}
