package com.nhnacademy.edu.jdbc1.service.login;

import com.nhnacademy.edu.jdbc1.domain.User;
import com.nhnacademy.edu.jdbc1.repository.JdbcUserRepository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultUserLoginService implements UserLoginService{
    UserRepository userRepository;

    public DefaultUserLoginService(DataSource dataSource) {
        this.userRepository = new JdbcUserRepository(dataSource);
    }

    @Override
    public Optional<User> getUser(Long id) {
       return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User userCompare(String name, String password) {
        return userRepository.matches(name, password);
    }
}
