package io.github.charlie.springframework.test.bean;

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
        hashMap.put("10001", "Charlie01");
        hashMap.put("10002", "Charlie02");
        hashMap.put("10003", "Charlie03");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}
