package com.nhnacademy.edu.jdbc1.service.login;

import com.nhnacademy.edu.jdbc1.domain.User;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    Optional<User> findById(int id);

    List<User> findAll();

    boolean matches(String name, String password);
}
