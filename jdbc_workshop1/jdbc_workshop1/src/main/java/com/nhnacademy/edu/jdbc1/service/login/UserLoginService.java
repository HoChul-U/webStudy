package com.nhnacademy.edu.jdbc1.service.login;

import com.nhnacademy.edu.jdbc1.domain.User;
import java.sql.Connection;
import java.util.List;

public interface UserLoginService {
    User getUser(Long id);

    List<User> getAllUsers();


}
