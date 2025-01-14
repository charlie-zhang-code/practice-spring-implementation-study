package io.github.charlie.springframework.beans.factory;

import io.github.charlie.springframework.beans.BeansException;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/13
 * @Description: 容器感知类，实现此接口，既能感知到所属的 BeanFactory
 */
public interface BeanFactoryAware extends Aware {
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
