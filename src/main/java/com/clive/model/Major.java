package com.clive.model;

public class Major {

    private Integer majorId;
    private String majorName;
//    private UserData userData;

    public Major() {

    }

    public Major(Integer majorId, String majorName) {
        this.setMajorId(majorId);
        this.setMajorName(majorName);
    }

//    public Major(UserData userData) {
//        this.setUserData(userData);
//    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

//    public UserData getUserData() {
//        return userData;
//    }
//
//    public void setUserData(UserData userData) {
//        this.userData = userData;
//    }
}
