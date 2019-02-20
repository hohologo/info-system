package com.clive.repository;


import com.clive.model.Department;
import com.clive.model.Major;
import com.clive.model.Role;
import com.clive.model.UserData;
import com.clive.repository.mapper.DepartmentRowMapper;
import com.clive.repository.mapper.MajorRowMapper;
import com.clive.repository.mapper.RoleRowMapper;
import com.clive.repository.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class AdminRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<UserData> getUserList() {

        String query = "select user.user_id,\n" +
                "       user.user_name,\n" +
                "       user.user_age,\n" +
                "       user.user_gender,\n" +
                "       user.phone,\n" +
                "       user.email,\n" +
                "       user.created_on,\n" +
                "       user.modified_on,\n" +
                "       department.dept_id,\n" +
                "       department.dept_name,\n" +
                "       major.major_id,\n" +
                "       major.major_name,\n" +
                "       role.role_id,\n" +
                "       role.role_name\n" +
                "from user\n" +
                "       left join department on user.dept_id = department.dept_id\n" +
                "       left join major on user.major_id = major.major_id\n" +
                "       left join role on user.role_id = role.role_id";

        return jdbcTemplate.query(query, new UserRowMapper());

    }


    public void addUser(UserData userData) {

        String query = "insert into user(user_id, user_name, user_age, user_gender, dept_id, major_id, phone, email, role_id, created_on) value(?,?,?,?,?,?,?,?,?,?)";

        jdbcTemplate.update(query, userData.getUserId(), userData.getUserName(), userData.getUserAge(),
                userData.getUserGender(),userData.getDepartment().getDeptId(),userData.getMajor().getMajorId(),
                userData.getPhone(), userData.getEmail(),userData.getRole().getRoleId(), Timestamp.valueOf(userData.getCreatedOn()));
    }

    public Integer getRoleId(Role roleName) {

        String query = "select role_id " +
                "from role\n" +
                "where role_name = ? ";
        try {
            return jdbcTemplate.queryForObject(query, Integer.class, roleName);
        } catch (EmptyResultDataAccessException e) {
            return 3;
        }
    }

    public void updateUser(UserData userData) {

        String query = "update user\n" +
                "set user.user_id    = ?,\n" +
                "    user.user_name   = ?,\n" +
                "    user.user_age    = ?,\n" +
                "    user.user_gender = ?,\n" +
                "    user.department  = ?,\n" +
                "    user.major       = ?,\n" +
                "    user.phone       = ?,\n" +
                "    user.email       = ?,\n" +
                "where user.user_id = ?";

        jdbcTemplate.update(query, userData.getUserId(), userData.getUserName(), userData.getUserAge(),
                userData.getUserGender(), userData.getDepartment(), userData.getMajor(), userData.getPhone(), userData.getEmail(), userData.getUserId());

    }

    public UserData getUserByUserId(String userId) {
        String query = "select user.user_id,\n" +
                "       user.user_name,\n" +
                "       user.user_age,\n" +
                "       user.user_gender,\n" +
                "       user.phone,\n" +
                "       user.email,\n" +
                "       user.created_on,\n" +
                "       user.modified_on,\n" +
                "       department.dept_id,\n" +
                "       department.dept_name,\n" +
                "       major.major_id,\n" +
                "       major.major_name,\n" +
                "       role.role_id,\n" +
                "       role.role_name\n" +
                "from user\n" +
                "       left join department on user.dept_id = department.dept_id\n" +
                "       left join major on user.major_id = major.major_id\n" +
                "       left join role on user.role_id = role.role_id\n" +
                "where user.user_id = ? ";

        try {
            return jdbcTemplate.queryForObject(query, new UserRowMapper(), userId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    public void deleteUser(Integer userId) {

        String query = "delete from user where user_id = ?";

        jdbcTemplate.update(query, userId);
    }


    public List<Department> getDepartmentList() {

        String query = "select department.dept_id, department.dept_name\n" +
                "from department";

        return jdbcTemplate.query(query, new DepartmentRowMapper());
    }

    public List<Major> getMajorList() {

        String query = "select major.major_id, major.major_name from major";

        return jdbcTemplate.query(query, new MajorRowMapper());
    }


    public List<Role> getRoleList() {

        String query = "select role.role_id, role.role_name from role";

        return jdbcTemplate.query(query, new RoleRowMapper());
    }

    public List<Major> getMajorListByDeptId(Integer deptId) {

        String query = "select major_id, major_name from major where dept_id = ?";

        return jdbcTemplate.query(query, new MajorRowMapper(), deptId);
    }
}
