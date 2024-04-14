package ru.yuzhakov.hw4task2.repositories;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.yuzhakov.hw4task2.model.DatabaseQuery;
import ru.yuzhakov.hw4task2.model.User;

import java.sql.*;
import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbc;
    private final DatabaseQuery query;

    public List<User> findAll() {
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(query.getSelectAll(), userRowMapper);
    }

    public User save(User user) {
        jdbc.update(query.getInsert(), user.getFirstName(), user.getLastName());
        return  user;
    }

    public void deleteById(int id) {
        jdbc.update(query.getDelete(), id);
    }

    public void update(User user) {
        jdbc.update(query.getUpdate(), user.getFirstName(), user.getLastName(), user.getId());
    }

    public User getOne(int id) {
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.query(query.getSelect() + id, userRowMapper).get(0);
    }
}
