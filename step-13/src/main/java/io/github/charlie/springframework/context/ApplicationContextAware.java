package io.github.charlie.springframework.context;

import io.github.charlie.springframework.beans.BeansException;
import io.github.charlie.springframework.beans.factory.Aware;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/13
 * @Description: 现此接口，既能感知到所属的 ApplicationContext
 */
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
