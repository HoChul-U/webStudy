package com.nhnacademy.edu.jdbc1.service.login;

import com.nhnacademy.edu.jdbc1.domain.User;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserLoginService implements UserLoginService{


    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
