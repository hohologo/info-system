package com.clive.model;

public class LoginUser {

    private String userId;
    private String password;
    private String roleName;

    public LoginUser(String userId, String password, String roleName) {
        this.userId = userId;
        this.password = password;
        this.roleName = roleName;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getRoleName() {
        return roleName;
    }
}
