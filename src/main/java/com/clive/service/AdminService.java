package com.clive.service;


import com.clive.model.Department;
import com.clive.model.Major;
import com.clive.model.Role;
import com.clive.model.UserData;
import com.clive.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.time.LocalDateTime.now;
import static java.util.Arrays.asList;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<UserData> getUserList() {

        return adminRepository.getUserList();

    }

    public void addUser(UserData userData) {

        userData.setCreatedOn(now());
        adminRepository.addUser(userData);

    }

    public void updateUser(UserData userData, String userId) {

//        Integer roleId = adminRepository.getRoleId(userData.getRole());

        adminRepository.updateUser(userData, userId);
    }

    public void deleteUserDataByUserId(String userId) {

        adminRepository.deleteUserDataByUserId(userId);
    }

    public List<Department> getDepartmentList() {

        return adminRepository.getDepartmentList();
    }

    public List<Major> getMajorListByDeptId(Integer deptId) {

        return deptId == null ? new ArrayList<>() : adminRepository.getMajorListByDeptId(deptId);
    }

    public List<Role> getRoleList() {

        return adminRepository.getRoleList();
    }

    public List<String> getGenders() {

        return asList("Male", "Female");
    }

    public UserData getUserDataById(String userId) {

        return adminRepository.getUserDataByUserId(userId);
    }
}


