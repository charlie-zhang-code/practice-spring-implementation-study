package io.github.charlie.springframework.context;

import io.github.charlie.springframework.beans.BeansException;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/9
 * @Description: TODO
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    //刷新容器
    void refresh() throws BeansException;

}
