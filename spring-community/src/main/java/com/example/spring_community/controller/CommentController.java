package com.example.spring_community.controller;

import com.example.spring_community.dto.common.ApiResponse;
import com.example.spring_community.dto.common.EmptyDto;
import com.example.spring_community.dto.comment.CommentResponse;
import com.example.spring_community.dto.comment.RegisterCommentRequest;
import com.example.spring_community.dto.comment.UpdateCommentRequest;
import com.example.spring_community.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/posts/{postId}/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CommentResponse>> registerComment(
            @PathVariable Long postId,
            @RequestBody RegisterCommentRequest request) {
        try {
            Long commentId = commentService.registerComment(postId, 1L, request);
            CommentResponse response = new CommentResponse(postId, commentId);
            ApiResponse<CommentResponse> apiResponse = new ApiResponse<>("comment_register_success", "댓글이 정상적으로 등록됐습니다.", response);
            return ResponseEntity.status(201).body(apiResponse);
        } catch (NoSuchElementException e) {
            ApiResponse<CommentResponse> errorResponse = new ApiResponse<>("not_found", e.getMessage(), null);
            return ResponseEntity.status(404).body(errorResponse);
        } catch (Exception e) {
            ApiResponse<CommentResponse> errorResponse = new ApiResponse<>("internal_server_error", e.getMessage(), null);
            return ResponseEntity.status(500).body(errorResponse);
        }
    }

    @PatchMapping("/{commentId}")
    public ResponseEntity<ApiResponse<CommentResponse>> updateComment(
            @PathVariable Long postId,
            @PathVariable Long commentId,
            @RequestBody UpdateCommentRequest request) {
        try {
            Long id = commentService.updateComment(postId, commentId, request);
            CommentResponse response = new CommentResponse(postId, id);
            ApiResponse<CommentResponse> apiResponse = new ApiResponse<>("comment_update_success", "댓글이 수정됐습니다.", response);
            return ResponseEntity.status(200).body(apiResponse);
        } catch (NoSuchElementException e) {
            ApiResponse<CommentResponse> errorResponse = new ApiResponse<>("not_found", e.getMessage(), null);
            return ResponseEntity.status(404).body(errorResponse);
        } catch (Exception e) {
            ApiResponse<CommentResponse> errorResponse = new ApiResponse<>("internal_server_error", e.getMessage(), null);
            return ResponseEntity.status(500).body(errorResponse);
        }
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<ApiResponse<EmptyDto>> deleteComment(
            @PathVariable Long postId,
            @PathVariable Long commentId) {
        try {
            commentService.deleteComment(postId, commentId);
            return ResponseEntity.status(204).build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(404).body(new ApiResponse<>("not_found", e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>("internal_server_error", e.getMessage(), null));
        }
    }
}