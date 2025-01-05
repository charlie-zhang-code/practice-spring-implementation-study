package io.github.charlie.springframework;

/**
 * 用于定义Bean对象，实现方式是以一个Object类型存储对象
 */
public class BeanDefinition {
    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
