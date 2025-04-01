package com.urfu.homework.controller;

import com.urfu.homework.model.User;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @PostMapping("/register")
    public String register(@Valid @RequestBody User user) {
        return "Регистрация успешна!";
    }
}