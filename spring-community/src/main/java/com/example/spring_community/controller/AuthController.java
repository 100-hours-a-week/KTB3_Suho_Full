package com.example.spring_community.controller;

import com.example.spring_community.dto.auth.LoginRequest;
import com.example.spring_community.dto.auth.LoginResponse;
import com.example.spring_community.dto.common.ApiResponse;
import com.example.spring_community.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/tokens")
    public ResponseEntity<ApiResponse<LoginResponse>> login(@RequestBody LoginRequest request) {
        try {
            LoginResponse response = authService.login(request);
            ApiResponse<LoginResponse> apiResponse = new ApiResponse<>("login_success", "로그인에 성공했습니다.", response);
            return ResponseEntity.status(200).body(apiResponse);
        } catch (IllegalArgumentException e) {
            ApiResponse<LoginResponse> errorResponse = new ApiResponse<>("invalid_request", e.getMessage(), null);
            return ResponseEntity.status(400).body(errorResponse);
        } catch (Exception e) {
            ApiResponse<LoginResponse> errorResponse = new ApiResponse<>("internal_server_error", e.getMessage(), null);
            return ResponseEntity.status(500).body(errorResponse);
        }
    }
}