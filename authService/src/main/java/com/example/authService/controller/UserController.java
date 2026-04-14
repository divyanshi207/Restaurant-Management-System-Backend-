package com.example.authService.controller;


import com.example.authService.dto.LoginRequestDTO;
import com.example.authService.entity.User;
import com.example.authService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login( @RequestBody LoginRequestDTO u){
        return userService.login(u);
    }
}
