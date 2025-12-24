package com.example.offline;

import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {

        // ❌ No database save
        // Just simulate successful registration

        model.addAttribute("message", "User registered successfully (offline mode)!");
        model.addAttribute("user", new User()); // reset form

        return "register";
    }
}


