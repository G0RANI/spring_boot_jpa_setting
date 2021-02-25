package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String getTest() {
        return "success";
    }


    @GetMapping("/user/{id}")
    public String read(@PathVariable Long id) {
        Optional<User> user = userService.findUser(id);
        user.ifPresent(System.out::println);
        return "successfully executed";
    }
}
