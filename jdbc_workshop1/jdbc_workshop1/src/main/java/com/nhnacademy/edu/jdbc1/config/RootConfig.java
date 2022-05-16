package com.nhnacademy.edu.jdbc1.config;

import com.nhnacademy.edu.jdbc1.Base;

import com.nhnacademy.edu.jdbc1.repository.JdbcUserRepository;
import com.nhnacademy.edu.jdbc1.service.login.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackageClasses = Base.class,
    excludeFilters = {@ComponentScan.Filter(Controller.class)})
public class RootConfig {
    @Bean
    public UserRepository userRepository(){
        UserRepository userRepository = new JdbcUserRepository();
        return userRepository;
    }

}
