package io.github.charlie.springframework.beans.factory;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/9
 * @Description: TODO
 */
public interface InitializingBean {
    // 处理了属性填充后调用
    void afterPropertiesSet() throws Exception;
}
