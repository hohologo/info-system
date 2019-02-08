package com.clive.repository;


import com.clive.model.User;
import com.clive.repository.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getUserList(){

        String query = "select * from user";

        return jdbcTemplate.query(query, new UserRowMapper());

    }


}
