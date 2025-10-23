package com.example.spring_community.dto.post;

public class RegisterPostResponse {
    private Long postId;

    public RegisterPostResponse(Long postId) {
        this.postId = postId;
    }

    public Long getPostId() {
        return postId;
    }
}
