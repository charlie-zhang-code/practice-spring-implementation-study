package io.github.charlie.springframework.beans.factory.config;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/9
 * @Description: TODO
 */
public class BeanReference {
    private final String beanName;
    public BeanReference(String beanName) {
        this.beanName = beanName;
    }
    public String getBeanName() {
        return beanName;
    }
}
