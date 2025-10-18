package com.example.spring_community.domain;

import java.util.Optional;

public class User {
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private Optional<String> profileImageUrl;

    public User (String email, String password, String nickname, Optional<String> profileImageUrl) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString(){
        return "User : { id: " + this.id + ", email: " + this.email + ", nickname: " + this.nickname + ", profileImageUrl: " + this.profileImageUrl + "}";
    }

}
