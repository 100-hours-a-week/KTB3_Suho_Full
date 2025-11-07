package com.example.spring_community.service;

import com.example.spring_community.entity.User;
import com.example.spring_community.repository.JpaUserRepository;
import com.example.spring_community.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JpaUserService {

    private final JpaUserRepository userRepository;

    @Transactional
    public User create(String email, String password, String nickname) {

        User user = new User(email, password, nickname);
        return userRepository.save(user);

    }
}
