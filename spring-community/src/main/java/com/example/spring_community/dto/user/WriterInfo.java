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

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Optional<String> getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(Optional<String> profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }
}
