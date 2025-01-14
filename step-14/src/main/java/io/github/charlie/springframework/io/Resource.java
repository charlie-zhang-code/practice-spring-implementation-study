package io.github.charlie.springframework.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/9
 * @Description: TODO
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
