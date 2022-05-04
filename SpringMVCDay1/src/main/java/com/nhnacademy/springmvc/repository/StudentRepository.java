package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.Student;

public interface StudentRepository {
    boolean exists(long id);

    Student register(String name, String email, int score, String comment);

    Student addStudent(long id, String name, String email, int score, String commenet);

    Student getStudent(long id);

    void modify(Student student);
}
