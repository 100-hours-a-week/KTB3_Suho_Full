package com.example.spring_community.domain;

import java.util.Optional;

public class User {
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private String profileImageUrl;

    public User (String email, String password, String nickname, String profileImageUrl) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
    }

    public User(Long id, String email, String password, String nickname, String profileImageUrl) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setId(Long id) {
        if(this.id != null) {
            throw new IllegalStateException("ID가 이미 할당되었습니다.");
        }
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    @Override
    public String toString(){
        return "User : { id: " + this.id + ", email: " + this.email + ", nickname: " + this.nickname + ", profileImageUrl: " + this.profileImageUrl + "}";
    }

}
