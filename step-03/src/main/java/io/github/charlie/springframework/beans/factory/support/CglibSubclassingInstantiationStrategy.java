package io.github.charlie.springframework.beans.factory.support;

import io.github.charlie.springframework.beans.BeansException;
import io.github.charlie.springframework.beans.factory.config.BeanDefinition;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * Cglib子类化实例化策略
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer(); // 创建Enhancer对象
        enhancer.setSuperclass(beanDefinition.getBeanClass()); // 设置父类
        enhancer.setCallback(new NoOp() { // 设置回调
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });

        // 如果没有构造函数，则创建一个无参构造函数
        if (null == ctor) {
            return enhancer.create(); // 创建对象
        }

        // 如果有构造函数，则创建一个带参构造函数
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
