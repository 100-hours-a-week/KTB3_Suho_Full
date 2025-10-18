package com.example.spring_community.controller;

import com.example.spring_community.dto.common.ApiResponse;
import com.example.spring_community.dto.common.EmptyDto;
import com.example.spring_community.dto.common.Pagination;
import com.example.spring_community.dto.post.*;
import com.example.spring_community.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping
    public ResponseEntity<ApiResponse<GetPostsResponse>> getPosts() {
        try {
            List<PostItem> posts = postService.getPosts();
            Pagination pagination = new Pagination(20, true, 1L);
            ApiResponse<GetPostsResponse> apiResponse = new ApiResponse<>("posts_success", "게시물 목록을 정상적으로 불러왔습니다.", new GetPostsResponse(posts, pagination));
            return ResponseEntity.status(200).body(apiResponse);
        } catch (Exception e) {
            ApiResponse<GetPostsResponse> errorResponse = new ApiResponse<>("internal_server_error", e.getMessage(), null);
            return ResponseEntity.status(500).body(errorResponse);
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<RegisterPostResponse>> registerPost(@RequestBody RegisterPostRequest request) {
        try {
            Long postId = postService.registerPost(1L, request);
            ApiResponse<RegisterPostResponse> apiResponse = new ApiResponse<>("post_register_success", "게시물이 정상적으로 등록됐습니다.", new RegisterPostResponse(postId));
            return ResponseEntity.status(200).body(apiResponse);
        } catch ( NoSuchElementException e) {
            ApiResponse<RegisterPostResponse> errorResponse = new ApiResponse<>("not_found", e.getMessage(), null);
            return ResponseEntity.status(404).body(errorResponse);
        } catch (Exception e) {
            ApiResponse<RegisterPostResponse> errorResponse = new ApiResponse<>("internal_server_error", e.getMessage(), null);
            return ResponseEntity.status(500).body(errorResponse);
        }
    }

    @GetMapping("/{postId}")
    public ResponseEntity<ApiResponse<DetailPostResponse>> getPostById(@PathVariable Long postId) {
        try {
            ApiResponse<DetailPostResponse> response = new ApiResponse<>("post_detail_success", "게시물(상세)를 정상적으로 불러왔습니다.", postService.getDetailPostById(postId));
            return ResponseEntity.status(200).body(response);
        }  catch ( NoSuchElementException e) {
            ApiResponse<DetailPostResponse> errorResponse = new ApiResponse<>("not_found", e.getMessage(), null);
            return ResponseEntity.status(404).body(errorResponse);
        } catch (Exception e) {
            ApiResponse<DetailPostResponse> errorResponse = new ApiResponse<>("internal_server_error", e.getMessage(), null);
            return ResponseEntity.status(500).body(errorResponse);
        }
    }

    @PutMapping("/{postId}")
    public ResponseEntity<ApiResponse<UpdatePostResponse>> updatePost(@PathVariable Long postId, @RequestBody UpdatePostRequest request) {
        try {
            Long id = postService.updatePost(postId, request);
            ApiResponse<UpdatePostResponse> response = new ApiResponse<>("post_update_success", "게시물이 수정됐습니다.", new UpdatePostResponse(id));
            return ResponseEntity.status(200).body(response);
        } catch ( NoSuchElementException e) {
            ApiResponse<UpdatePostResponse> errorResponse = new ApiResponse<>("not_found", e.getMessage(), null);
            return ResponseEntity.status(404).body(errorResponse);
        } catch (Exception e) {
            ApiResponse<UpdatePostResponse> errorResponse = new ApiResponse<>("internal_server_error", e.getMessage(), null);
            return ResponseEntity.status(500).body(errorResponse);
        }
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<ApiResponse<EmptyDto>> deletePost(@PathVariable Long postId) {
        try {
            postService.deletePost(postId);
            return ResponseEntity.status(204).build();
        }  catch ( NoSuchElementException e) {
            return ResponseEntity.status(404).body(new ApiResponse<>("not_found", e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>("internal_server_error", e.getMessage(), null));
        }
    }

    @PostMapping("/{postId}/likes")
    public ResponseEntity<ApiResponse<LikeToggleResponse>> likeToggle(@PathVariable Long postId) {
        try {
            Long likeId = postService.toggleLike(postId, 1L);
            if (likeId == null) {
                return ResponseEntity.status(204).build();
            }
            else {
                return ResponseEntity.status(200).body(new ApiResponse<>("like_toggle_success", "좋아요를 눌렀습니다.", new LikeToggleResponse(likeId)));
            }
        } catch ( NoSuchElementException e) {
            return ResponseEntity.status(404).body(new ApiResponse<>("not_found", e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>("internal_server_error", e.getMessage(), null));
        }
    }
}
