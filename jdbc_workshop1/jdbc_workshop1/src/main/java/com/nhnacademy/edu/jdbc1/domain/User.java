package com.nhnacademy.edu.jdbc1.domain;

import lombok.Data;
import java.util.Date;

@Data
public class User {
    private final Long id;
    private final String name;
    private final String passWord;
    private final Date createdAt;

    public User(Long id, String name, String passWord, Date createdAt) {
        this.id = id;
        this.name = name;
        this.passWord = passWord;
        this.createdAt = createdAt;
    }
}
