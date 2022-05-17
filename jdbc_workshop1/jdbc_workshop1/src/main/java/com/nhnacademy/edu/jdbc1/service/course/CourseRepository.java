package com.nhnacademy.edu.jdbc1.service.course;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository {
    Optional<Course> findById(Long id);

    List<Course> findAll();

    int insert(Course user);

    int delete(Long id);

    int modify(Long id, Long teacherId,Long subjectId);
}
