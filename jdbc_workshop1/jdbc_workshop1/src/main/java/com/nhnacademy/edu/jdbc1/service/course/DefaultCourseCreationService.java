package com.nhnacademy.edu.jdbc1.service.course;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultCourseCreationService implements CourseCreationService {
    private   CourseRepository courseRepository;


    @Override
    public Optional<Course> getCourse(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Transactional
    @Override
    public void insertCourse(Course course) {
        courseRepository.insert(course);
    }

    @Transactional
    @Override
    public void deleteCourse(Long id) {
        courseRepository.delete(id);
    }
    @Transactional
    @Override
    public void modifyCourse(Long id, Long teacherId, Long subjectId) {
        courseRepository.modify(id, teacherId, subjectId);
    }
}
