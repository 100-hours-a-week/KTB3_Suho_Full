package com.example.spring_community.repository;

import com.example.spring_community.domain.User;
import com.example.spring_community.dto.user.MyPageUserInfo;
import com.example.spring_community.dto.user.WriterInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {
    private final JpaUserRepository jpaUserRepository;

    @Override
    public Long registerUser(User user) {
        User savedUser = jpaUserRepository.save(user);
        return 0L;
    }

    @Override
    public void deleteUser(Long userId) {

    }

    @Override
    public void patchUserNickname(Long userId, String nickname) {

    }

    @Override
    public void patchUserPassword(Long userId, String password) {

    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    @Override
    public boolean existsByNickname(String nickname) {
        return false;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public boolean isEqualsOldPassword(Long id, String newPassword) {
        return false;
    }

    @Override
    public MyPageUserInfo getMyPageUserInfo(Long userId) {
        return null;
    }

    @Override
    public WriterInfo getWriterInfo(Long userId) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }
}
