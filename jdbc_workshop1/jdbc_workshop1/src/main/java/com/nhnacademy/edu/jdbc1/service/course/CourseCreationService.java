package com.nhnacademy.edu.jdbc1.service.course;

import java.util.List;
import java.util.Optional;

public interface CourseCreationService {

    Optional<Course> getCourse(Long id);

    List<Course> getAllCourses();

    void insertCourse(Course course);

    void deleteCourse(Long id);

    void modifyCourse(Long id, Long teacherId, Long subjectId);
}
