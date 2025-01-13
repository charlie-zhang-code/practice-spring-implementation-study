package io.github.charlie.springframework.context;

import io.github.charlie.springframework.beans.factory.HierarchicalBeanFactory;
import io.github.charlie.springframework.beans.factory.ListableBeanFactory;
import io.github.charlie.springframework.io.ResourceLoader;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/9
 * @Description: TODO
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
