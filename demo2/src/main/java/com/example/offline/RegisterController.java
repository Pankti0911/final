package com.example.offline;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String register(@RequestBody User user) {
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        return "register";
    }

    // @GetMapping("/register")
    // public String register() {
    //     return "Welcome In Spring Boot";
    // }
}











