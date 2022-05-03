package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.domain.StudentNoIdRegister;
import com.nhnacademy.springmvc.exception.InputException;
import com.nhnacademy.springmvc.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@RequestMapping("/students/register")
public class StudentsRegisterController {

    private final StudentRepository studentRepository;

    public StudentsRegisterController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public ModelAndView studentRegisterForm() {
        ModelAndView view = new ModelAndView("thymeleaf/studentRegister");
        return view;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ModelAndView registerStudent(@Valid @RequestBody StudentNoIdRegister student,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputException();
        }
        Student students = studentRepository.register(student.getName(), student.getEmail(), student.getScore(),
                student.getComment());
        ModelAndView view = new ModelAndView("thymeleaf/studentView");
        view.addObject("student", students);
        return view;
    }
}

