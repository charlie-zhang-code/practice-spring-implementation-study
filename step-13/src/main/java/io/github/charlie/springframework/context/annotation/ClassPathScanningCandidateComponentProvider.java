package io.github.charlie.springframework.context.annotation;

import cn.hutool.core.util.ClassUtil;
import io.github.charlie.springframework.beans.factory.config.BeanDefinition;
import io.github.charlie.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/14
 * @Description: TODO
 */
public class ClassPathScanningCandidateComponentProvider {
    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
