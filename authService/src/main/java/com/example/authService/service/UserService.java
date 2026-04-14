package com.example.authService.service;

import com.example.authService.dto.LoginRequestDTO;
import com.example.authService.entity.User;
import com.example.authService.repository.UserRepository;
import com.example.authService.utility.GenerateToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;

    @Autowired
    GenerateToken generateToken;

//    @PostMapping("/register")
    public String register(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User Registered";
    }

//    postmapping login
    public String login(@RequestBody LoginRequestDTO requestDTO){
        User user=userRepository.findByUsername(requestDTO.getUsername());
        if(!passwordEncoder.matches(requestDTO.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid credentials");
        }
        String token= generateToken.generateToken(user.getUsername(),user.getRole());
        return token;
    }
}
