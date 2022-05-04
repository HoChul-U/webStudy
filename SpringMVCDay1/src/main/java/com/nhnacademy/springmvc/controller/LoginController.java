package com.nhnacademy.springmvc.controller;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (Objects.isNull(session)) {
            return "thymeleaf/login";
        }
        return "thymeleaf/home";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("id") String id,
                          @RequestParam("pwd") String pwd,
                          HttpServletRequest request,
                          ModelMap modelMap) {

        if (id.contains("admin") && pwd.contains("12345")) {
            HttpSession session = request.getSession(true);
            modelMap.put("id", session.getId());

            return "thymeleaf/home";
        } else {
            return "redirect:thymeleaf/login";
        }
    }
}
