package io.github.charlie.springframework.test.bean;

import io.github.charlie.springframework.beans.factory.annotation.Autowired;
import io.github.charlie.springframework.beans.factory.annotation.Value;
import io.github.charlie.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/14
 * @Description: TODO
 */
public class UserService implements IUserService {
    private String token;


    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Charlie 10001，" + token;
    }

    @Override
    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "注册用户：" + userName + " success!";
    }

    @Override
    public String toString() {
        return "UserService#token = { " + token + " }";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
