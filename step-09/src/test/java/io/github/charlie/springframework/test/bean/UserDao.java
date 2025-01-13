package io.github.charlie.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/7
 * @Description: TODO
 */
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

//    static {
//        hashMap.put("10001", "Charlie1");
//        hashMap.put("10002", "Charlie2");
//        hashMap.put("10003", "Charlie3");
//    }

    public void initDataMethod(){
        System.out.println("执行：init-method");
        hashMap.put("10001", "Charlie1");
        hashMap.put("10002", "Charlie2");
        hashMap.put("10003", "Charlie3");
    }

    public void destroyDataMethod(){
        System.out.println("执行：destroy-method");
        hashMap.clear();
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
