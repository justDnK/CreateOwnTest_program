package com.example.test_programe.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.test_programe.model.CurrentUser;
import com.example.test_programe.model.User;
import com.example.test_programe.model.UserRole;
import com.example.test_programe.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/registration")
    public void registrationFunction(
        @RequestBody User user
    ) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserRole(UserRole.ROLE_USER);
        userService.saveUser(user);
    }

    @GetMapping("/account/me")
    public CurrentUser getInfoUser(
        Authentication authentication
    ) {
        User user = userService.findByEmail(authentication.getName());
        return new CurrentUser(user.getId(), user.getName());
    }

    
}
