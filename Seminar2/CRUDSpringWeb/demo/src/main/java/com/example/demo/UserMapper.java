package com.example.demo;

import com.example.demo.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setFirstName(rs.getString("firstName"));
        user.setLastName(rs.getString("lastName"));
        user.setId(rs.getInt("id"));
        return user;
    }
}
