package com.clive.model;

public class Department {

    private Integer deptId;
    private String deptName;
//    private UserData userData;

    public Department() {
    }

    public Department(Integer deptId, String deptName) {
        this.setDeptId(deptId);
        this.setDeptName(deptName);
    }

//    public Department(UserData userData) {
//        this.setUserData(userData);
//    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

//    public UserData getUserData() {
//        return userData;
//    }
//
//    public void setUserData(UserData userData) {
//        this.userData = userData;
//    }
}
