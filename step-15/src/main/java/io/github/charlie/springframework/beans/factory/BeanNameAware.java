package io.github.charlie.springframework.beans.factory;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/13
 * @Description: 实现此接口，既能感知到所属的 BeanName
 */
public interface BeanNameAware extends Aware {
    void setBeanName(String name);
}
