package com.clive.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserData {

    private String userId;
    private String userName;
    private Integer userAge;
    private String userGender;
    private Department department;
    private Major major;
    private String phone;
    private String email;
    private Role role;
    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;


    public UserData(String userId, String userName, Integer userAge, String userGender, Department department, Major major, String phone, String email, Role role, LocalDateTime createdOn, LocalDateTime modifiedOn) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
        this.userGender = userGender;
        this.department = department;
        this.major = major;
        this.phone = phone;
        this.email = email;
        this.role = role;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
    }

    public UserData() {

    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public String getUserGender() {
        return userGender;
    }

    public Department getDepartment() {
        return department;
    }

    public Major getMajor() {
        return major;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LocalDateTime getModifiedOn() {
        return modifiedOn;
    }


    public String getFormattedCreatedOn() {

        return createdOn == null ? null : createdOn.format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss"));
    }

    public String getFormattedModifiedOn() {

        return modifiedOn == null ? null : modifiedOn.format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss"));
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public void setDepartment(Department department) {
        this.department = department;
//        department.setUserData(this);
    }

    public void setMajor(Major major) {
        this.major = major;
//        major.setUserData(this);
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(Role role) {
        this.role = role;
//        role.setUserData(this);
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public void setModifiedOn(LocalDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

//    public void addDepartment(Department department) {
//        this.department = department;
//        department.setUserData(this);
//    }
//
//    public void addMajor(Major major) {
//        this.major = major;
//        major.setUserData(this);
//    }
//
//    public void addRole(Role role) {
//        this.role = role;
//        role.setUserData(this);
//    }
}
