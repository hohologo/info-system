package com.clive.repository.mapper;

import com.clive.model.Department;
import com.clive.model.Major;
import com.clive.model.Role;
import com.clive.model.UserData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class UserDataRowMapper implements RowMapper<UserData> {


    public UserData mapRow(ResultSet resultSet, int i) throws SQLException {
        String useId = resultSet.getString("user_id");
        String userName = resultSet.getString("user_name");
        Integer userAge = resultSet.getInt("user_age");
        String userGender = resultSet.getString("user_gender");
        String phone = resultSet.getString("phone");
        String email = resultSet.getString("email");
        LocalDateTime createdTimestamp = convertSQLToLocal(resultSet.getTimestamp("created_on"));
        LocalDateTime modifiedTimestamp = convertSQLToLocal(resultSet.getTimestamp("modified_on"));
        Department department = createDepartment(resultSet.getInt("dept_id"), resultSet.getString("dept_name"));
        Major major = createMajor(resultSet.getInt("major_id"), resultSet.getString("major_name"));
        Role role = createRole(resultSet.getInt("role_id"), resultSet.getString("role_name"));

        return new UserData(useId, userName, userAge, userGender, department, major, phone, email, role, createdTimestamp, modifiedTimestamp);
    }

    private LocalDateTime convertSQLToLocal(Timestamp createdOn) {

        return createdOn == null ? null : createdOn.toLocalDateTime();
    }

    private Department createDepartment(Integer deptId, String deptName) {

        return deptId == 0 ? null : new Department(deptId, deptName);
    }

    private Major createMajor(Integer majorId, String majorName) {

        return majorId == 0 ? null : new Major(majorId, majorName);
    }

    private Role createRole(Integer roleId, String roleName) {

        return roleId == 0 ? null : new Role(roleId, roleName);
    }

}
