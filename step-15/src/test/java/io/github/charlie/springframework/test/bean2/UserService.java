package io.github.charlie.springframework.test.bean2;

import io.github.charlie.springframework.beans.factory.annotation.Autowired;
import io.github.charlie.springframework.beans.factory.annotation.Value;
import io.github.charlie.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/14
 * @Description: TODO
 */
@Component
public class UserService implements IUserService {
    @Value("${token}")
    private String token;

    @Autowired
    private UserDao userDao;


    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userDao.queryUserName("10001") + token;
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

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
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
