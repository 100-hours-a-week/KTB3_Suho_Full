package com.example.spring_community.controller;

import com.example.spring_community.dto.common.CommonApiResponse;
import com.example.spring_community.dto.common.EmptyDto;
import com.example.spring_community.dto.comment.CommentResponse;
import com.example.spring_community.dto.comment.RegisterCommentRequest;
import com.example.spring_community.dto.comment.UpdateCommentRequest;
import com.example.spring_community.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/posts/{postId}/comments")
@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation =
        CommonApiResponse.class)))
@ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation =
        CommonApiResponse.class)))
@ApiResponse(responseCode = "500", description = "internal_server_error", content = @Content(schema = @Schema(implementation =
        CommonApiResponse.class)))
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    @Operation(summary = "댓글 등록", description = "새로운 댓글을 등록합니다.")
    @ApiResponse(responseCode = "201", description = "Created")
    public ResponseEntity<CommonApiResponse<CommentResponse>> registerComment(
            @PathVariable Long postId,
            @RequestBody RegisterCommentRequest request) {
        Long commentId = commentService.registerComment(postId, 1L, request);
        CommentResponse response = new CommentResponse(postId, commentId);
        CommonApiResponse<CommentResponse> commonApiResponse = new CommonApiResponse<>("comment_register_success", "댓글이 정상적으로 등록됐습니다.", response);
        return ResponseEntity.status(201).body(commonApiResponse);
    }

    @PatchMapping("/{commentId}")
    @Operation(summary = "댓글 수정", description = "댓글을 수정합니다.")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<CommonApiResponse<CommentResponse>> updateComment(
            @PathVariable Long postId,
            @PathVariable Long commentId,
            @RequestBody UpdateCommentRequest request) {
        Long id = commentService.updateComment(postId, commentId, request);
        CommentResponse response = new CommentResponse(postId, id);
        CommonApiResponse<CommentResponse> commonApiResponse = new CommonApiResponse<>("comment_update_success", "댓글이 수정됐습니다.", response);
        return ResponseEntity.status(200).body(commonApiResponse);
    }

    @DeleteMapping("/{commentId}")
    @Operation(summary = "댓글 삭제", description = "댓글을 삭제합니다.")
    @ApiResponse(responseCode = "204", description = "No Content")
    public ResponseEntity<Void> deleteComment(
            @PathVariable Long postId,
            @PathVariable Long commentId) {
        commentService.deleteComment(postId, commentId);
        return ResponseEntity.status(204).build();
    }
}