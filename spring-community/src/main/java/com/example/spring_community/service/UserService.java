package com.example.spring_community.service;

import com.example.spring_community.dto.user.RegisterUserRequest;
import com.example.spring_community.dto.user.MyPageUserInfo;
import com.example.spring_community.repository.UserRepository;
import com.example.spring_community.domain.User;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long registerUser(RegisterUserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("이미 등록된 이메일입니다."); // 400 Error
        }
        if (userRepository.existsByNickname(request.getNickname())) {
            throw new IllegalArgumentException("이미 등록된 닉네임입니다."); // 400 Error
        }
        User user = new User(request.getEmail(), request.getPassword(), request.getNickname(), request.getProfileImageUrl());
        return userRepository.registerUser(user);
    }

    public void deleteUser(Long userId) {
        throwUserNotFoundException(userId);
        userRepository.deleteUser(userId);
    }

    public void patchUserNickname(Long userId, String nickname) {
        if (userRepository.existsByNickname(nickname)) {
            throw new IllegalArgumentException("이미 존재하거나 현재 사용 중인 닉네임입니다."); // 400 Error
        }
        userRepository.patchUserNickname(userId, nickname);
    }

    public void patchUserPassword(Long userId, String password) {
        throwUserNotFoundException(userId);
        // TODO: 401 Error, accessToken이 만료된 경우(로그인이 안 된 경우)
        // TODO: 403 Error, 본인이 아닌 경우(권한이 없을 때)
        if (userRepository.isEqualsOldPassword(userId, password)) {
            throw new IllegalArgumentException("이미 사용 중인 비밀번호입니다."); // 400 Error
        }
        userRepository.patchUserPassword(userId, password);
    }

    public MyPageUserInfo getMyPageUserInfo(Long userId) {
        throwUserNotFoundException(userId);
        // TODO: 401 Error, accessToken이 만료된 경우(로그인이 안 된 경우)
        // TODO: 403 Error, 본인이 아닌 경우(권한이 없을 때)
        return userRepository.getMyPageUserInfo(userId);
    }

    private void throwUserNotFoundException(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new NoSuchElementException("존재하지 않는 userId 입니다.");
        }
    }
}
