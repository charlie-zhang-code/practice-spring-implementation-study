package io.github.charlie.springframework.beans.factory.config;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/9
 * @Description: TODO
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
                                                