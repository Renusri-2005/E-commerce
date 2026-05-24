package com.example.E_commerce.service;

import com.example.E_commerce.dto.AuthResponse;
import com.example.E_commerce.dto.LoginRequest;
import com.example.E_commerce.dto.RegisterRequest;
import com.example.E_commerce.model.User;
import com.example.E_commerce.repository.UserRepository;
import com.example.E_commerce.security.JwtUtil;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;

    // REGISTER USER

    public String register(RegisterRequest request) {

        // CHECK EMAIL EXISTS

        if(userRepository.findByEmail(request.getEmail()).isPresent()) {
            return "Email Already Exists";
        }

        // CREATE USER

        User user = new User();

        user.setName(request.getName());

        user.setEmail(request.getEmail());

        // ENCRYPT PASSWORD

        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        user.setRole("USER");

        // SAVE USER

        userRepository.save(user);

        return "User Registered Successfully";
    }

    // LOGIN USER

    public AuthResponse login(LoginRequest request) {

        // FIND USER

        User user = userRepository.findByEmail(
                request.getEmail()
        ).orElseThrow(() ->
                new RuntimeException("User Not Found")
        );

        // CHECK PASSWORD

        if(!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        )) {

            throw new RuntimeException("Invalid Password");
        }

        // GENERATE JWT TOKEN

        String token =
                jwtUtil.generateToken(user.getEmail());

        return new AuthResponse(token);
    }
}