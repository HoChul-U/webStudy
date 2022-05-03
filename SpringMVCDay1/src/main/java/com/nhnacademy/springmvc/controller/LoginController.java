package com.nhnacademy.springmvc.controller;

import java.util.Objects;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("thymeleaf/login")
    public String login(@CookieValue(value = "SESSION", required = false) String session,
                        Model model) {
        if (Objects.isNull(session)) {
            throw new RuntimeException();
        }
        model.addAttribute("id", session);
        return "thymeleaf/home";
    }

    @PostMapping("thymeleaf/login")
    public String doLogin(@RequestParam("id") String id,
                          @RequestParam("pwd") String pwd,
                          HttpServletRequest request,
                          HttpServletResponse response,
                          ModelMap modelMap) {
        if (id.contains("admin") && pwd.contains("12345")) {

            HttpSession session = request.getSession(true);

            Cookie cookie = new Cookie("SESSION", session.getId());
            response.addCookie(cookie);

            modelMap.put("id", session.getId());
            return "thymeleaf/home";
        } else {
            return "redirect:thymeleaf/login";
        }
    }
}
