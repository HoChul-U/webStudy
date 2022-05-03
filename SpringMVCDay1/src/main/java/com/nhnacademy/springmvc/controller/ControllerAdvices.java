package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.exception.StudentNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvices {
    @ExceptionHandler({StudentNotFoundException.class})
    public String handleEx(Exception ex, Model model){
        model.addAttribute("exception",ex);
        return "thymeleaf/error";
    }
}
