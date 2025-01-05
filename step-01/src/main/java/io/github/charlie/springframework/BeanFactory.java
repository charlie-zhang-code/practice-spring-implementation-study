package io.github.charlie.springframework;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 代表Bean对象的工厂，可以将Bean对象的定义存储到Map中以便获取Bean对象，用于生成和使用对象的Bean工厂
 */
public class BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    // 获取Bean
    public Object getBean(String beanName) {
        return beanDefinitionMap.get(beanName).getBean();
    }

    // 注册Bean
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
