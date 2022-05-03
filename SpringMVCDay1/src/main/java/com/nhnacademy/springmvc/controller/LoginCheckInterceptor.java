package com.nhnacademy.springmvc.controller;

import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        HttpSession session= request.getSession(false);
        if (Objects.isNull(session) || Objects.isNull(session.getAttribute("id"))){
            response.sendRedirect("thymeleaf/home");
            return false;
        }

        return true;
    }
}
