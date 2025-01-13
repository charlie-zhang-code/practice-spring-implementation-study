package io.github.charlie.springframework.beans.factory.config;
import io.github.charlie.springframework.beans.BeansException;
import io.github.charlie.springframework.beans.factory.BeanFactory;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/9
 * @Description: TODO
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
    // 实现BeanPostProcessor
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
