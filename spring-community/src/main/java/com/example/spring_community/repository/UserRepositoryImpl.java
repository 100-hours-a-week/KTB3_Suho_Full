package com.example.spring_community.repository;

import com.example.spring_community.domain.User;
import com.example.spring_community.dto.user.MyPageUserInfo;
import com.example.spring_community.dto.user.WriterInfo;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private Map<Long, User> users;
    private Long sequence = 1L;  // 1부터 시작

    public UserRepositoryImpl() {
        users = new LinkedHashMap<>();
        initTestData();
    }

    private void initTestData() {
        // 테스트 유저 1
        registerUser(new User("test1@example.com", "password123", "테스터1", "https://example.com/profile1.jpg"));
        // 테스트 유저 2
        registerUser(new User("test2@example.com", "password456", "테스터2", null));
        // 테스트 유저 3
        registerUser(new User("admin@example.com", "admin1234", "관리자", "https://example.com/admin.jpg"));
    }

    public UserRepositoryImpl(Map<Long, User> users) {
        this.users = users;
    }

    @Override
    public Long registerUser(User user) {
        if (user.getId() == null) {
            while (existsById(sequence)) {
                sequence++;
            }
            user.setId(sequence);
        }
        users.put(user.getId(), user);
        return user.getId();
    }

    @Override
    public void deleteUser(Long userId) {
        users.remove(userId);
    }

    @Override
    public void patchUserNickname(Long userId, String nickname) {
        User user = users.get(userId);
        if (user != null) {
            users.get(userId).updateNickname(nickname);
        }
    }

    @Override
    public void patchUserPassword(Long userId, String password) {
        User user = users.get(userId);
        if (user != null) {
            users.get(userId).updatePassword(password);
        }
    }

    @Override
    public boolean existsByEmail(String email) {
        return users.values().stream().anyMatch(user -> user.getEmail().equals(email));
    }

    @Override
    public boolean existsByNickname(String nickname) {
        return users.values().stream().anyMatch(user -> user.getNickname().equals(nickname));
    }

    @Override
    public boolean existsById(Long id) {
        return users.containsKey(id);
    }

    @Override
    public boolean isEqualsOldPassword(Long id, String newPassword) {
        User user = users.get(id);
        if (user != null) {
            return user.getPassword().equals(newPassword);
        }
        return true;
    }

    @Override
    public MyPageUserInfo getMyPageUserInfo(Long userId) {
        User user = users.get(userId);
        return new MyPageUserInfo(user.getEmail(), user.getNickname(), user.getPassword());
    }

    @Override
    public WriterInfo getWriterInfo(Long userId) {
        User user = users.get(userId);
        return new WriterInfo(user.getId(), user.getNickname(), user.getProfileImageUrl());
    }

    @Override
    public User findByEmail(String email) {
        return users.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }
}

