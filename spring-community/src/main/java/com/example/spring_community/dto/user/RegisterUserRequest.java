package com.example.spring_community.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterUserRequest {
    @NotBlank(message = "이메일은 필수 입력입니다.")
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    @Size(max = 50, message = "이메일의 길이는 최대 50자까지 입니다.")
    private String email;
    @NotBlank(message = "비밀번호은 필수 입력입니다.")
    @Size(min = 8, max = 50, message = "비밀번호의 길이는 최소 8자, 최대 50자까지 입니다.")
    private String password;
    @NotBlank(message = "닉네임은 필수 입력입니다.")
    @Size(min = 2, max = 20, message = "닉네임의 길이는 최소 2자, 최대 20자까지 입니다.")
    @Pattern(regexp = "^[가-힣a-zA-Z0-9]+$",
            message = "닉네임은 한글, 영문, 숫자만 사용 가능합니다.")
    private String nickname;
    @Size(max = 500, message = "프로필 이미지 URL의 길이는 500자까지 입니다.")
    private String profileImageUrl;

    public RegisterUserRequest(String email, String password, String nickname, String profileImageUrl) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
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
}
