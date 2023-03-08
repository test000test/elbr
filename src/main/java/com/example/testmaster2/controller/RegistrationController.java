package com.example.testmaster2.controller;

import com.example.testmaster2.entity.User;
import com.example.testmaster2.service.serviceImpl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RegistrationController {
    private final UserServiceImpl userService;

    // Registration
    @PostMapping("/registration")
    public ResponseEntity<User> registrationUser(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors() || userService.loadUserByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(userService.RegistrationUser(user));
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<UserDetails> loginUser(@Valid @RequestBody String username, BindingResult result) {
        return ResponseEntity.ok().body(userService.loadUserByUsername(username));
    }
}
