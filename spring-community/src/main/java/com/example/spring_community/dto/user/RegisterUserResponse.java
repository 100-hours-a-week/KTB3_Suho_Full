package com.example.spring_community.dto.user;

public class RegisterUserResponse {
    private Long userId;

    public RegisterUserResponse(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

}
