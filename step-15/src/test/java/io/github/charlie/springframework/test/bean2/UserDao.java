package io.github.charlie.springframework.test.bean2;

import io.github.charlie.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/14
 * @Description: TODO
 */
@Component
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "Charlie1");
        hashMap.put("10002", "Charlie2");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
