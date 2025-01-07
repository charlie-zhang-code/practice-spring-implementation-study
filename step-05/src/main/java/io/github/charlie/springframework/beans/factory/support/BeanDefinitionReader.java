package io.github.charlie.springframework.beans.factory.support;

import io.github.charlie.springframework.beans.BeansException;
import io.github.charlie.springframework.core.io.Resource;
import io.github.charlie.springframework.core.io.ResourceLoader;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/7
 * @Description: TODO
 */
public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
}
