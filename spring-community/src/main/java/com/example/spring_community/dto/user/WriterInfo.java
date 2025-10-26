package com.example.spring_community.dto.user;

public class WriterInfo {
    private Long userId;
    private String nickname;
    private String profileImageUrl;

    public WriterInfo(Long userId, String nickname, String profileImageUrl) {
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

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

}
