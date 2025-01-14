package io.github.charlie.springframework.context.event;

import io.github.charlie.springframework.beans.factory.BeanFactory;
import io.github.charlie.springframework.context.ApplicationEvent;
import io.github.charlie.springframework.context.ApplicationListener;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/13
 * @Description: TODO
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {
    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }
}
