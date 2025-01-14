package io.github.charlie.springframework.beans.factory;

import io.github.charlie.springframework.beans.BeansException;

import java.util.Map;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/9
 * @Description: TODO
 */
public interface ListableBeanFactory extends BeanFactory {

    //按照类型返回实例
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    //返回注册表中所有的名称
    String[] getBeanDefinitionNames();
}
