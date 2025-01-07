package io.github.charlie.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/7
 * @Description: 资源加载接口定义与实现
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
