package com.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        // Отображает шаблон src/main/resources/templates/login.html
        return "login";
    }

    // При желании можно добавить методы для регистрации
    // @GetMapping("/register") ...
    // @PostMapping("/register") ...
}
