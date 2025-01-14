package io.github.charlie.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import io.github.charlie.springframework.beans.BeansException;
import io.github.charlie.springframework.beans.factory.DisposableBean;
import io.github.charlie.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/9
 * @Description: TODO
 */
public class DisposableBeanAdapter implements DisposableBean {
    private final Object bean;
    private final String beanName;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        // 如果不是DisposableBean接口，并且有destroy方法，则调用destroy方法
        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            Method method = bean.getClass().getMethod(destroyMethodName);
            if (null == method) {
                throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }

            method.invoke(bean);
        }
    }
}
