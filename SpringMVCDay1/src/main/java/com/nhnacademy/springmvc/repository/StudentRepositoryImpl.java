package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.exception.StudentNotFoundException;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class StudentRepositoryImpl implements StudentRepository {
    private final Map<Long, Student> studentRepository = new ConcurrentHashMap<>();

    private static long count=0;
    @Override
    public boolean exists(long id) {
        return studentRepository.containsKey(id);
    }

    @Override
    public Student register(String name, String email, int score, String comment) {
        Long id = studentRepository.keySet()
            .stream()
            .max(Comparator.comparing(Function.identity()))
            .map(l -> l + 1)
            .orElse(1L);
        studentRepository.put(id, new Student(id, name, email, score, comment));
        return  studentRepository.get(id);
    }

    @Override
    public Student getStudent(long id) {
        if(!exists(id)){
            throw new StudentNotFoundException();
        }
        return studentRepository.get(id);
    }

    @Override
    public void modify(Student student) {
        Student checkStudent = studentRepository.get(student.getId());
        if (Objects.isNull(checkStudent)) {
            throw new StudentNotFoundException();
        }
        checkStudent.setComment(student.getComment());
        checkStudent.setEmail(student.getEmail());
        checkStudent.setName(student.getName());
        checkStudent.setScore(student.getScore());
    }
}
