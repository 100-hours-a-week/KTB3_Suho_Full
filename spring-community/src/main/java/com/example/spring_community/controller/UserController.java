package com.example.spring_community.controller;

import com.example.spring_community.dto.common.CommonApiResponse;
import com.example.spring_community.dto.common.EmptyDto;
import com.example.spring_community.dto.user.*;
import com.example.spring_community.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
@ApiResponse(responseCode = "400", description = "Bad Request",
        content = @Content(schema = @Schema(implementation =
                CommonApiResponse.class)))
@ApiResponse(responseCode = "500", description = "Internal_server_error",
        content = @Content(schema = @Schema(implementation =
                CommonApiResponse.class)))
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    @Operation(summary = "회원가입", description = "새로운 사용자 정보를 등록합니다.")
    @ApiResponse(responseCode = "201", description = "Created")
    public ResponseEntity<CommonApiResponse<RegisterUserResponse>> registerUser(@Valid @RequestBody RegisterUserRequest request) {
        Long userId = userService.registerUser(request);
        CommonApiResponse<RegisterUserResponse> commonApiResponse = new CommonApiResponse<>("register_success", "회원 등록이 정상적으로 완료됐습니다.", new RegisterUserResponse(userId));
        return ResponseEntity.status(201).body(commonApiResponse);
    }


    @GetMapping("/{id}")
    @Operation(summary = "사용자 정보 조회", description = "ID를 통해 특정 사용자 정보를 조회합니다.")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Not Found",
            content = @Content(schema = @Schema(implementation =
                    CommonApiResponse.class)))
    public ResponseEntity<CommonApiResponse<MyPageUserInfo>> getUserInfo(@PathVariable Long id) {
        MyPageUserInfo userInfo = userService.getMyPageUserInfo(id);
        CommonApiResponse<MyPageUserInfo> commonApiResponse = new CommonApiResponse<>("user_information_success", "회원 정보 조회가 정상적으로 완료됐습니다.", userInfo);
        return ResponseEntity.status(200).body(commonApiResponse);
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "회원탈퇴", description = "ID를 통해 특정 사용자의 정보를 삭제합니다.")
    @ApiResponse(responseCode = "204", description = "No Content")
    @ApiResponse(responseCode = "404", description = "Not Found",
            content = @Content(schema = @Schema(implementation =
                    CommonApiResponse.class)))
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(204).build();
    }


    @PatchMapping("/{id}/nickname")
    @Operation(summary = "닉네임 변경", description = "ID를 통해 특정 사용자의 닉네임을 변경합니다.")
    @ApiResponse(responseCode = "204", description = "No Content")
    @ApiResponse(responseCode = "404", description = "Not Found",
            content = @Content(schema = @Schema(implementation =
                    CommonApiResponse.class)))
    public ResponseEntity<Void> patchUserNickname(@PathVariable Long id, @Valid @RequestBody PatchUserNicknameRequest request) {
        userService.patchUserNickname(id, request.getNickname());
        return ResponseEntity.status(204).build();
    }

    @PatchMapping("/{id}/password")
    @Operation(summary = "비밀번호 변경", description = "ID를 통해 특정 사용자의 비밀번호를 변경합니다.")
    @ApiResponse(responseCode = "204", description = "NoContent")
    @ApiResponse(responseCode = "404", description = "Not Found",
            content = @Content(schema = @Schema(implementation =
                    CommonApiResponse.class)))
    public ResponseEntity<Void> patchUserPassword(@PathVariable Long id, @Valid @RequestBody PatchUserPasswordRequest request) {
        userService.patchUserPassword(id, request.getPassword());
        return ResponseEntity.status(204).build();
    }
}
