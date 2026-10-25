package com.pm.auth_service.service;

import com.pm.auth_service.dto.LoginRequestDTO;
import com.pm.auth_service.util.JwtUtil;
import io.jsonwebtoken.JwtException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {


    private UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtutil;

    public AuthService(UserService userService, PasswordEncoder passwordEncoder, JwtUtil jwtutil) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtutil = jwtutil;
    }

    public Optional<String>  authenticate(LoginRequestDTO loginRequestDTO) {
        return userService.findByEmail(loginRequestDTO.getEmail())
                .filter(u -> passwordEncoder.matches(loginRequestDTO.getPassword(),
                        u.getPassword()))
                .map( u -> jwtutil.generateToken(u.getEmail(),u.getRole()));

    }


    public boolean validateToken(String token) {
        try{
            jwtutil.validateToken(token);
            return true;
        } catch(JwtException e){
            return false;
        }

    }
}
