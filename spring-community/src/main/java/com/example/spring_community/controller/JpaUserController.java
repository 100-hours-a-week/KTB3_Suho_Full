package com.example.spring_community.controller;

import com.example.spring_community.dto.user.RegisterUserRequest;
import com.example.spring_community.service.JpaUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class JpaUserController {

    private final JpaUserService userService;

    @PostMapping
    public void create(@RequestBody RegisterUserRequest request) {

        System.out.println("test");

    }

}
