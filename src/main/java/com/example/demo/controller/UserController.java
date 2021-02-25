package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor //생성자 주입을 위한 어노테이션
public class UserController {

    private final UserService userService;

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
