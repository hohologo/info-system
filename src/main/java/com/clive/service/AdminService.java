package com.clive.service;


import com.clive.model.Department;
import com.clive.model.Major;
import com.clive.model.Role;
import com.clive.model.UserData;
import com.clive.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.LocalDateTime.now;
import static java.util.Arrays.asList;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<UserData> getUserList(){

        return adminRepository.getUserList();

    }

    public void addUser(UserData userData) {

        userData.setCreatedOn(now());
        adminRepository.addUser(userData);

    }

    public void updateUser(UserData userData) {

//        Integer roleId = adminRepository.getRoleId(userData.getRole());

        adminRepository.updateUser(userData);
    }

    public UserData getUserByUserId(String userId) {

        return adminRepository.getUserByUserId(userId);
    }

    public void deleteUser(Integer userId) {

        adminRepository.deleteUser(userId);
    }

    public List<Department> getDepartmentList() {

        return adminRepository.getDepartmentList();
    }

    public List<Major> getMajorListByDeptId(Integer departmentId) {

        return adminRepository.getMajorListByDeptId(departmentId);
    }

    public List<Role> getRoleList() {

        return adminRepository.getRoleList();
    }

    public List<String> getGenders() {

        return asList("Male","Female");
    }
}
