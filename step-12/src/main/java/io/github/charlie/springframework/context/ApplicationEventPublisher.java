package io.github.charlie.springframework.context;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/13
 * @Description: 事件发布者的定义和实现
 */
public interface ApplicationEventPublisher {
    void publishEvent(ApplicationEvent event);
}
