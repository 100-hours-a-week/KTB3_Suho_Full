package com.example.spring_community.controller;

import com.example.spring_community.dto.common.ApiResponse;
import com.example.spring_community.dto.common.EmptyDto;
import com.example.spring_community.dto.user.*;
import com.example.spring_community.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<ApiResponse<RegisterUserResponse>> registerUser(@Valid @RequestBody RegisterUserRequest request) {
        try {
            Long userId = userService.registerUser(request);
            ApiResponse<RegisterUserResponse> apiResponse = new ApiResponse<>("register_success","회원 등록이 정상적으로 완료됐습니다.", new RegisterUserResponse(userId));
            return ResponseEntity.status(201).body(apiResponse);
        } catch (IllegalArgumentException e) {
            ApiResponse<RegisterUserResponse> errorResponse = new ApiResponse<>("invalid_request", e.getMessage(), null);
            return ResponseEntity.status(400).body(errorResponse);
        } catch (Exception e) {
            ApiResponse<RegisterUserResponse> errorResponse = new ApiResponse<>("internal_server_error", e.getMessage(), null);
            return ResponseEntity.status(500).body(errorResponse);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<MyPageUserInfo>> getUserInfo(@PathVariable Long id){
        try {
            MyPageUserInfo userInfo = userService.getMyPageUserInfo(id);
            ApiResponse<MyPageUserInfo> apiResponse = new ApiResponse<>("user_information_success", "회원 정보 조회가 정상적으로 완료됐습니다.", userInfo);
            return ResponseEntity.status(200).body(apiResponse);
        } catch (NoSuchElementException e) {
            ApiResponse<MyPageUserInfo> errorResponse = new ApiResponse<>("not_found", e.getMessage(), null);
            return  ResponseEntity.status(404).body(errorResponse);
        } catch (Exception e) {
            ApiResponse<MyPageUserInfo> errorResponse = new ApiResponse<>("internal_server_error", e.getMessage(), null);
            return ResponseEntity.status(500).body(errorResponse);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<EmptyDto>> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.status(204).build();
        } catch (NoSuchElementException e) {
            ApiResponse<EmptyDto> errorResponse = new ApiResponse<>("not_found", e.getMessage(), null);
            return ResponseEntity.status(404).body(errorResponse);
        } catch (Exception e) {
            ApiResponse<EmptyDto> errorResponse = new ApiResponse<>("internal_server_error", e.getMessage(), null);
            return ResponseEntity.status(500).body(errorResponse);
        }
    }

    @PatchMapping("/{id}/nickname")
    public ResponseEntity<ApiResponse<EmptyDto>> patchUserNickname(@PathVariable Long id, @Valid @RequestBody PatchUserNicknameRequest request) {
        try {
            userService.patchUserNickname(id, request.getNickname());
            return ResponseEntity.status(204).build();
        } catch (IllegalArgumentException e) {
            ApiResponse<EmptyDto> errorResponse = new ApiResponse<>("invalid_request", e.getMessage(), null);
            return ResponseEntity.status(400).body(errorResponse);
        } catch (NoSuchElementException e) {
            ApiResponse<EmptyDto> errorResponse = new ApiResponse<>("not_found", e.getMessage(), null);
            return ResponseEntity.status(404).body(errorResponse);
        } catch (Exception e) {
            ApiResponse<EmptyDto> errorResponse = new ApiResponse<>("internal_server_error", e.getMessage(), null);
            return ResponseEntity.status(500).body(errorResponse);
        }
    }

    @PatchMapping("/{id}/password")
    public ResponseEntity<ApiResponse<EmptyDto>> patchUserPassword(@PathVariable Long id, @Valid @RequestBody PatchUserPasswordRequest request) {
        try {
            userService.patchUserPassword(id, request.getPassword());
            return ResponseEntity.status(204).build();
        } catch (IllegalArgumentException e) {
            ApiResponse<EmptyDto> errorResponse = new ApiResponse<>("invalid_request", e.getMessage(), null);
            return ResponseEntity.status(400).body(errorResponse);
        } catch (NoSuchElementException e) {
            ApiResponse<EmptyDto> errorResponse = new ApiResponse<>("not_found", e.getMessage(), null);
            return ResponseEntity.status(404).body(errorResponse);
        } catch (Exception e) {
            ApiResponse<EmptyDto> errorResponse = new ApiResponse<>("internal_server_error", e.getMessage(), null);
            return ResponseEntity.status(500).body(errorResponse);
        }
    }
}
