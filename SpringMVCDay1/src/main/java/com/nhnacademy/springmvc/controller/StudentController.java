package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.exception.InputException;
import com.nhnacademy.springmvc.exception.StudentNotFoundException;
import com.nhnacademy.springmvc.repository.StudentRepository;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @ModelAttribute("student")
    public Student getStudent(@PathVariable("studentId") long studentId) {
        Student student = studentRepository.getStudent(studentId);
        if(Objects.isNull(student)){
            throw new StudentNotFoundException();
        }
        return student;
    }

    @GetMapping("/{studentId}")
    public String viewStudent(@Valid @ModelAttribute("student") Student student,
                              BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            throw new InputException();
        }
        model.addAttribute("student",student);
        return "studentView";
    }
    @GetMapping(value = "/{studentId}",params = "hideScore=yes")
    public ModelAndView hideViewStudent(@Valid @ModelAttribute("student")Student student,
                                  Errors errors){
        if(errors.hasErrors()){
            throw new InputException();
        }
        ModelAndView view = new ModelAndView("thymeleaf/studentHideView");
        view.addObject("student", student);
        return view;
    }

    @GetMapping("/{studentId}/modify")
    public ModelAndView studentModifyForm(@ModelAttribute("student") Student student) {
        if(Objects.isNull(student)){
            throw new StudentNotFoundException();
        }
        ModelAndView view = new ModelAndView("thymeleaf/studentModify");
        view.addObject("student", student);
        return view;
    }

    @PutMapping("/{studentId}/modify")
    public String modifyStudent(@Valid @ModelAttribute("student") Student student,
                                BindingResult bindingResult,ModelMap map) {
        if(bindingResult.hasErrors()){
            throw new InputException();
        }
        studentRepository.modify(student);
        map.put("student",student);
        return "thymeleaf/studentView";
    }

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void notFound(StudentNotFoundException ex,Model model){
        model.addAttribute("studentNotFound",ex);
    }

}
