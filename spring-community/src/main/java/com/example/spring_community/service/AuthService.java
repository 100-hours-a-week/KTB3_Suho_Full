package com.example.spring_community.service;

import com.example.spring_community.domain.User;
import com.example.spring_community.dto.auth.LoginRequest;
import com.example.spring_community.dto.auth.LoginResponse;
import com.example.spring_community.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail());

        if (user == null) {
            throw new IllegalArgumentException("이메일 또는 비밀번호가 올바르지 않습니다.");
        }

        if (!user.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("이메일 또는 비밀번호가 올바르지 않습니다.");
        }

        String accessToken = "access_token_" + user.getId() + "_" + System.currentTimeMillis();
        String refreshToken = "refresh_token_" + user.getId() + "_" + System.currentTimeMillis();

        return new LoginResponse(accessToken, refreshToken);
    }
}