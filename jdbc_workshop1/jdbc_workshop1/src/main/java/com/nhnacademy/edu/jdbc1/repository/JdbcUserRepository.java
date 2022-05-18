package com.nhnacademy.edu.jdbc1.repository;

import com.nhnacademy.edu.jdbc1.domain.User;
import com.nhnacademy.edu.jdbc1.service.course.Course;
import com.nhnacademy.edu.jdbc1.service.login.UserRepository;

import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcUserRepository implements UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<User> findById(int id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(
            "select * from JdbcUsers where id = ?",
            (resultSet, rowNum) ->
                new User(resultSet.getLong("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getTimestamp("created_at"))
        ));
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(
            "select id,username,password,created_at from JdbcUsers",
            (resultSet, rowNum) ->
                new User(resultSet.getLong("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getTimestamp("created_at")));
    }

    @Override
    public boolean matches(String name, String password) {
        return false;
    }
}
