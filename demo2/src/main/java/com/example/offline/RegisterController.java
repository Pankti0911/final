package com.example.offline;

import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        return "register";
    }
}

