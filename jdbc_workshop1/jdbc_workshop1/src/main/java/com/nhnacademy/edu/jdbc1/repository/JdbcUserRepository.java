package com.nhnacademy.edu.jdbc1.repository;

import com.nhnacademy.edu.jdbc1.domain.User;
import com.nhnacademy.edu.jdbc1.service.course.Course;
import com.nhnacademy.edu.jdbc1.service.login.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
public class JdbcUserRepository implements UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(
                "select * from JdbcUsers where id = ?",
                (resultSet, rowNum) ->
                        new User(resultSet.getLong("id"),
                                resultSet.getString("username"),
                                resultSet.getString("password"),
                                resultSet.getTimestamp("created_at")),
                id
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
    public User matches(String name, String password) {
       return jdbcTemplate.queryForObject(
                "select * from JdbcUsers where username =? and password =?",
                (resultSet, rowNum) ->
                        new User(resultSet.getLong("id"),
                                resultSet.getString("username"),
                                resultSet.getString("password"),
                                resultSet.getTimestamp("created_at"))
                , name, password);
    }
}