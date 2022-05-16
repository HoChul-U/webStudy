package com.nhnacademy.edu.jdbc1.repository;

import com.nhnacademy.edu.jdbc1.domain.User;
import com.nhnacademy.edu.jdbc1.service.login.UserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class JdbcUserRepository implements UserRepository {
    @Override
    public Optional<User> findById(int id) {
        try(Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM JdbcUsers WHERE id=?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(new User(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("password"),
                        resultSet.getTimestamp("created_at")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try(Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM JdbcUsers");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                users.add(
                        new User(resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getString("password"),
                                resultSet.getTimestamp("created_at"))
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean matches(String name, String password) {
        try(Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM JdbcUsers WHERE name=? AND password=?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int insert(User user) {
        try(Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO JdbcUsers (id,name,password,created_at) VALUES(?,?,?,?)");
            preparedStatement.setLong(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3,user.getPassWord());
            preparedStatement.setTimestamp(4, new Timestamp(new Date().getTime()));
            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        try(Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM JdbcUsers WHERE id=?");
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int modify(int id, String username, String userPassword) {
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE JdbcUsers SET name=?, password=? WHERE =?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, userPassword);
            preparedStatement.setLong(3, id);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
