package com.example.spring_community.controller;

import com.example.spring_community.dto.auth.LoginRequest;
import com.example.spring_community.dto.auth.LoginResponse;
import com.example.spring_community.dto.common.CommonApiResponse;
import com.example.spring_community.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/tokens")
    @Operation(summary = "로그인", description = "ID, 비밀번호를 통해 등록된 사용자인지 확인합니다.")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation =
            CommonApiResponse.class)))
    @ApiResponse(responseCode = "500", description = "internal_server_error", content = @Content(schema = @Schema(implementation =
            CommonApiResponse.class)))
    public ResponseEntity<CommonApiResponse<LoginResponse>> login(@RequestBody LoginRequest request) {
        LoginResponse response = authService.login(request);
        CommonApiResponse<LoginResponse> commonApiResponse = new CommonApiResponse<>("login_success", "로그인에 성공했습니다.", response);
        return ResponseEntity.status(200).body(commonApiResponse);
    }
}