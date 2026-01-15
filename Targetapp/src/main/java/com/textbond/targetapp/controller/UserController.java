package com.textbond.targetapp.controller;

import com.textbond.targetapp.dto.UserRegisterRequest;
import com.textbond.targetapp.model.User;
import com.textbond.targetapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")

public class UserController {

    private final UserService userService;

    // Constructor Injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CREATE USER
    @PostMapping
    public User createUser(@Valid @RequestBody UserRegisterRequest user) {
        return userService.createUser(user);
    }

    // GET ALL USERS
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
