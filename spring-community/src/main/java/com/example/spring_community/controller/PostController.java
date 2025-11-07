package com.example.spring_community.controller;

import com.example.spring_community.dto.common.CommonApiResponse;
import com.example.spring_community.dto.common.EmptyDto;
import com.example.spring_community.dto.post.*;
import com.example.spring_community.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

import static com.example.spring_community.util.PaginationConstants.DEFAULT_CURSOR;
import static com.example.spring_community.util.PaginationConstants.DEFAULT_SIZE_STRING;

@RestController
@RequestMapping("/posts")
@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation =
        CommonApiResponse.class)))
@ApiResponse(responseCode = "500", description = "internal_server_error", content = @Content(schema = @Schema(implementation =
        CommonApiResponse.class)))
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    @Operation(summary = "게시물 목록 조회", description = "게시물 목록을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<CommonApiResponse<GetPostsResponse>> getPosts(
            @RequestParam(required = false, defaultValue = DEFAULT_SIZE_STRING) int size,
            @RequestParam(required = false) Long nextCursor ) {
        nextCursor = nextCursor == null ? DEFAULT_CURSOR : nextCursor;
        GetPostsResponse postsResponse = postService.getPosts(size, nextCursor);
        CommonApiResponse<GetPostsResponse> commonApiResponse = new CommonApiResponse<>("posts_success", "게시물 목록을 정상적으로 불러왔습니다.", postsResponse);
        return ResponseEntity.status(200).body(commonApiResponse);
    }

    @PostMapping
    @Operation(summary = "게시물 등록", description = "새로운 게시물을 등록합니다.")
    @ApiResponse(responseCode = "201", description = "Created")
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = CommonApiResponse.class)))
    public ResponseEntity<CommonApiResponse<RegisterPostResponse>> registerPost(@RequestBody RegisterPostRequest request) {
        Long postId = postService.registerPost(1L, request);
        CommonApiResponse<RegisterPostResponse> commonApiResponse = new CommonApiResponse<>("post_register_success", "게시물이 정상적으로 등록됐습니다.", new RegisterPostResponse(postId));
        return ResponseEntity.status(201).body(commonApiResponse);
    }

    @GetMapping("/{postId}")
    @Operation(summary = "게시물 상세 조회", description = "게시물ID를 통해 게시물 상세 정보를 조회합니다.")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = CommonApiResponse.class)))
    public ResponseEntity<CommonApiResponse<DetailPostResponse>> getPostById(@PathVariable Long postId) {
        CommonApiResponse<DetailPostResponse> response = new CommonApiResponse<>("post_detail_success", "게시물(상세)를 정상적으로 불러왔습니다.", postService.getDetailPostById(postId));
        return ResponseEntity.status(200).body(response);
    }

    @PutMapping("/{postId}")
    @Operation(summary = "게시물 수정", description = "게시물의 제목, 내용, 이미지를 수정합니다.")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = CommonApiResponse.class)))
    public ResponseEntity<CommonApiResponse<UpdatePostResponse>> updatePost(@PathVariable Long postId, @RequestBody UpdatePostRequest request) {
        Long id = postService.updatePost(postId, request);
        CommonApiResponse<UpdatePostResponse> response = new CommonApiResponse<>("post_update_success", "게시물이 수정됐습니다.", new UpdatePostResponse(id));
        return ResponseEntity.status(200).body(response);
    }

    @DeleteMapping("/{postId}")
    @Operation(summary = "게시물 삭제", description = "게시물ID를 통해 게시물을 삭제합니다.")
    @ApiResponse(responseCode = "204", description = "No Content")
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = CommonApiResponse.class)))

    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.status(204).build();
    }

    @PostMapping("/{postId}/likes")
    @Operation(summary = "좋아요 toggle", description = "게시물ID를 통해 해당 게시물의 좋아요 상태를 변경합니다.")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = CommonApiResponse.class)))
    public ResponseEntity<CommonApiResponse<LikeToggleResponse>> likeToggle(@PathVariable Long postId) {
        Long likeId = postService.toggleLike(postId, 1L);
        if (likeId == null) {
            return ResponseEntity.status(200).body(new CommonApiResponse<>("like_toggle_success", "좋아요를 추가했습니다.", new LikeToggleResponse(likeId)));
        }
        else {
            return ResponseEntity.status(200).body(new CommonApiResponse<>("like_toggle_success", "좋아요를 삭제했습니다.", new LikeToggleResponse(likeId)));
        }
    }
}
