package io.github.charlie.springframework.context.event;

import io.github.charlie.springframework.context.ApplicationEvent;
import io.github.charlie.springframework.context.ApplicationListener;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/13
 * @Description: TODO
 */
public interface ApplicationEventMulticaster {
    void addApplicationListener(ApplicationListener<?> listener);
    void removeApplicationListener(ApplicationListener<?> listener);
    void multicastEvent(ApplicationEvent event);
}
