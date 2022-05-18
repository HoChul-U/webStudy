package com.nhnacademy.edu.jdbc1.service.login;

import com.nhnacademy.edu.jdbc1.domain.User;

import java.util.List;
import java.util.Optional;


public interface UserLoginService {
    Optional<User> getUser(Long id);

    List<User> getAllUsers();

    User userCompare(String name, String password);
}
