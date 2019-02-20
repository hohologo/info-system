package com.clive.model;

public class Role {

    private Integer roleId;
    private String roleName;
//    private UserData userData;

    public Role() {

    }

    public Role(Integer roleId, String roleName) {
        this.setRoleId(roleId);
        this.setRoleName(roleName);
    }

//    public Role(UserData userData) {
//        this.setUserData(userData);
//    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

//    public UserData getUserData() {
//        return userData;
//    }
//
//    public void setUserData(UserData userData) {
//        this.userData = userData;
//    }
}
