package com.musashi.spring_boot_jwt.controller;

import com.musashi.spring_boot_jwt.model.AuthRequest;
import com.musashi.spring_boot_jwt.model.RefreshRequest;
import com.musashi.spring_boot_jwt.model.TokenPair;
import com.musashi.spring_boot_jwt.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService){
        this.authService = authService;
    }


    @PostMapping("/register")
    void register(@Valid @RequestBody AuthRequest body){
        authService.register(body.getEmail(), body.getPassword());
    }

    @PostMapping("/login")
    TokenPair login(@RequestBody AuthRequest body) {
        return authService.login(body.getEmail(), body.getPassword());
    }

    @PostMapping("/refresh")
    TokenPair refresh(@RequestBody RefreshRequest body) {
        return authService.refresh(body.getRefreshToken());
    }
}
