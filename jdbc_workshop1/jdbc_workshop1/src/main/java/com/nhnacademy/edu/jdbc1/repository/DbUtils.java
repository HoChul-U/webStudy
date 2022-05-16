package com.nhnacademy.edu.jdbc1.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://133.186.211.156:3306/nhn_academy_16", "nhn_academy_16", "ANQDj5vXfM@1vTo@");

    }
}
