package com.example.spring_community.dto.user;

import java.util.Optional;

public class WriterInfo {
    private Long userId;
    private String nickname;
    private Optional<String> profileImageUrl;

    public WriterInfo(Long userId, String nickname, Optional<String> profileImageUrl) {
        this.userId = userId;
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
    }

    public Long getUserId() {
        return userId;
    }

    public String getNickname() {
        return nickname;
    }

    public Optional<String> getProfileImageUrl() {
        return profileImageUrl;
    }

}
