package io.github.charlie.springframework.test.bean;

public class UserService {
    private String name;

    public UserService() {
    }

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("Query user info: " + name);
    }

    @Override
    public String toString() {
//        return "UserService{" +
//                "name='" + name + '\'' +
//                '}';

        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }
}
