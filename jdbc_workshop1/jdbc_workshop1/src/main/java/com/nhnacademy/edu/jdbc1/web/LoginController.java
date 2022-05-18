package com.nhnacademy.edu.jdbc1.web;

import com.nhnacademy.edu.jdbc1.service.login.UserLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class LoginController {
    private final UserLoginService userLoginService;

    public LoginController(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    @GetMapping(value = {"/","/login"})
    public String login(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (Objects.nonNull(session)) {
            model.addAttribute("id", session.getAttribute("id"));
            return "loginSuccess";
        } else {
            return "loginForm";
        }
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("id") String id,
                          @RequestParam("pwd") String pwd,
                          HttpServletRequest request,
                          HttpServletResponse response,
                          ModelMap modelMap) {
        if (Objects.nonNull(userLoginService.userCompare(id, pwd))) {
            HttpSession session = request.getSession(true);
            session.setAttribute("id", id);
            modelMap.put("id", id);

            return "loginSuccess";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }

}
