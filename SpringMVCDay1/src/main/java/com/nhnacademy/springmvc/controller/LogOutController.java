package com.nhnacademy.springmvc.controller;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogOutController {

    @GetMapping("thymeleaf/logout")
    public String LogOut(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(Objects.nonNull(session)){
            session.invalidate();
        }
        return "thymeleaf/login";
    }

}


