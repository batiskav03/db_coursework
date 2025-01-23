package com.senechka.course_back.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Возвращает страницу входа
    }

    @GetMapping("/home")
    public String home() {
        return "home"; // Возвращает главную страницу после входа
    }
} 