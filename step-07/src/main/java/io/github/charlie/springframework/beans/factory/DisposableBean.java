package io.github.charlie.springframework.beans.factory;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/9
 * @Description: TODO
 */
public interface DisposableBean {
    // 销毁方法
    void destroy() throws Exception;
}
