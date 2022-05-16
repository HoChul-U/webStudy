package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.domain.StudentNoIdRegister;
import com.nhnacademy.springmvc.domain.StudentRegister;
import com.nhnacademy.springmvc.exception.InputException;
import com.nhnacademy.springmvc.exception.StudentNotFoundException;
import com.nhnacademy.springmvc.repository.StudentRepository;

import java.util.Objects;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class StudentsController {
    private final StudentRepository studentRepository;

    public StudentsController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<Student> viewStudent(@PathVariable("studentId") long studentId) {
        return ResponseEntity.ok().body(studentRepository.getStudent(studentId));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/students/{studentId}")
    public Student modifyStudent(@RequestBody StudentNoIdRegister studentNoIdRegister,
                                      @PathVariable long studentId) {
        Student modifyStudent = new Student(studentId,
                studentNoIdRegister.getName(),
                studentNoIdRegister.getEmail(),
                studentNoIdRegister.getScore(),
                studentNoIdRegister.getComment());

       return studentRepository.modify(modifyStudent);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/students")
    public void CreateStudent(@RequestBody StudentRegister studentRegister) {
        studentRepository.addStudent(
                studentRegister.getId(),
                studentRegister.getName(),
                studentRegister.getEmail(),
                studentRegister.getScore(),
                studentRegister.getComment());
    }
}
