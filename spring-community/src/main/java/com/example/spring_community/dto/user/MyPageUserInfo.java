package com.example.spring_community.dto.user;

public class MyPageUserInfo {
    private String email;
    private String nickname;
    private String profileImageUrl;

    public MyPageUserInfo(String email, String nickname, String profileImageUrl) {
        this.email = email;
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
    }

    public String getEmail() {
        return email;
    }


    public String getNickname() {
        return nickname;
    }


    public String getProfileImageUrl() {
        return profileImageUrl;
    }

}
