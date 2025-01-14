package io.github.charlie.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/14
 * @Description: TODO
 */
public interface Advisor {
    Advice getAdvice();
}
