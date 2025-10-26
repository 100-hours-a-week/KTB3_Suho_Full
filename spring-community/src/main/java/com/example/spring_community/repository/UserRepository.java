package com.example.spring_community.repository;


import com.example.spring_community.domain.User;
import com.example.spring_community.dto.user.MyPageUserInfo;
import com.example.spring_community.dto.user.PatchUserPasswordRequest;
import com.example.spring_community.dto.user.WriterInfo;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public interface UserRepository {
    Long registerUser(User user);

    void deleteUser(Long userId);

    void patchUserNickname(Long userId, String nickname);

    void patchUserPassword(Long userId, String password);

    boolean existsByEmail(String email);

    boolean existsByNickname(String nickname);

    boolean existsById(Long id);

    boolean isEqualsOldPassword(Long id, String newPassword);

    MyPageUserInfo getMyPageUserInfo(Long userId);

    WriterInfo getWriterInfo(Long userId);

    User findByEmail(String email);
}