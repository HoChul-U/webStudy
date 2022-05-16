package com.nhnacademy.edu.jdbc1.service.login;

import com.nhnacademy.edu.jdbc1.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(int id);

    List<User> findAll();

    boolean matches(String name, String password);

    int insert(User user);

    int delete(int id);

    int modify(int id, String username,String userPassword);
}
