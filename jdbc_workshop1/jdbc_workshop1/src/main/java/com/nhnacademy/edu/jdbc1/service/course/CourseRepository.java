package com.nhnacademy.edu.jdbc1.service.course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {
    Optional<Course> findById(int id);

    List<Course> findAll();

    int insert(Course user);

    int delete(int id);

    int modify(int id, int teacherId,int subjectId);
}
