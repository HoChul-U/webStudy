package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.domain.StudentNoIdRegister;
import com.nhnacademy.springmvc.domain.StudentRegister;
import com.nhnacademy.springmvc.exception.InputException;
import com.nhnacademy.springmvc.repository.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student/register")
public class StudentRegisterController {
    private final StudentRepository studentRepository;

    public StudentRegisterController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public String studentRegisterForm() {
        return "thymeleaf/studentRegister";
    }

    @PostMapping
    public String registerStudent(@Valid @ModelAttribute StudentNoIdRegister student,
                                  BindingResult bindingResult,
                                  @RequestParam("hideScore") String hideScore, Model model) {
        if (bindingResult.hasErrors()) {
            throw new InputException();
        }
        Student register =
                studentRepository.register(student.getName(), student.getEmail(), student.getScore(),
                        student.getComment());
        if (hideScore.contains("yes")) {
            model.addAttribute("hideScore", hideScore);
            model.addAttribute("student", register);
            return "thymeleaf/studentHideView";
        }
        model.addAttribute("student", register);
        return "thymeleaf/studentView";
    }

    @ExceptionHandler(InputException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String inputEx(InputException ex, Model model) {
        model.addAttribute("InputEx", ex);
        return "thymeleaf/error";
    }
}
