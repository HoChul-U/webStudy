package com.nhnacademy.edu.jdbc1.web;

import com.nhnacademy.edu.jdbc1.service.login.UserRepository;
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

@Controller
public class LoginController {
    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String login(@CookieValue(value = "SESSION", required = false) String session,
                        Model model) {
        if (StringUtils.hasText(session)) {
            model.addAttribute("id", session);
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
        if (userRepository.matches(id, pwd)) {
            HttpSession session = request.getSession(true);

            Cookie cookie = new Cookie("SESSION", session.getId());
            response.addCookie(cookie);
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
