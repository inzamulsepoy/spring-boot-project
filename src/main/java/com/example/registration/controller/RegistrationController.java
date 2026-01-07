package com.example.registration.controller;

import com.example.registration.model.User;
import com.example.registration.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private final UserRepository userRepository;

    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String showForm(User user) {
        return "register";
    }

    @PostMapping("/register")
    public String submitForm(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            model.addAttribute("errorMessage", "Email already registered");
            return "register";
        }
        userRepository.save(user);
        model.addAttribute("name", user.getName());
        return "success";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/register";
    }
}