package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.exception.InputException;
import com.nhnacademy.springmvc.exception.StudentNotFoundException;
import com.nhnacademy.springmvc.repository.StudentRepository;
import java.util.Objects;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/students")
public class StudentsController {
    private final StudentRepository studentRepository;

    public StudentsController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @ModelAttribute("students")
    public ResponseEntity<Student> getStudent(@PathVariable("studentId") long studentId) {
        return ResponseEntity.ok().body(studentRepository.getStudent(studentId));
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> viewStudent(@PathVariable("studentId") long studentId) {
        return ResponseEntity.ok().body(studentRepository.getStudent(studentId));
    }

    @GetMapping(value = "/{studentId}",params = "hideScore=yes")
    public ModelAndView hideViewStudent(@Valid @RequestBody @ModelAttribute("student")Student student,
                                        Errors errors){
        if(errors.hasErrors()){
            throw new InputException();
        }
        ModelAndView view = new ModelAndView("thymeleaf/studentHideView");
        view.addObject("student", student);
        return view;
    }

    @GetMapping("/{studentId}/modify")
    public ModelAndView studentModifyForm(@RequestBody @ModelAttribute("student") Student student) {
        if(Objects.isNull(student)){
            throw new StudentNotFoundException();
        }
        ModelAndView view = new ModelAndView("thymeleaf/studentModify");
        view.addObject("student", student);
        return view;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{studentId}/modify")
    public ModelAndView modifyStudent(@Valid Student student,
                                BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new InputException();
        }
        studentRepository.modify(student);
        ModelAndView view = new ModelAndView("thymeleaf/studentView");
        return view;
    }
}
