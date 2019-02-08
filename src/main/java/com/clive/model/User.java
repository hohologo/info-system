package com.clive.model;

public class User {

    private Integer userId;
    private String userNum;
    private String userName;
    private String password;
    private Integer userAge;
    private String userGender;
    private String department;
    private String major;
    private String phone;
    private String email;
    private Integer roleId;

    public User(Integer userId, String userNum, String userName, String password, Integer userAge, String userGender, String department, String major, String phone, String email, Integer roleId) {
        this.userId = userId;
        this.userNum = userNum;
        this.userName = userName;
        this.password = password;
        this.userAge = userAge;
        this.userGender = userGender;
        this.department = department;
        this.major = major;
        this.phone = phone;
        this.email = email;
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserNum() {
        return userNum;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public String getUserGender() {
        return userGender;
    }

    public String getDepartment() {
        return department;
    }

    public String getMajor() {
        return major;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Integer getRoleId() {
        return roleId;
    }
}
