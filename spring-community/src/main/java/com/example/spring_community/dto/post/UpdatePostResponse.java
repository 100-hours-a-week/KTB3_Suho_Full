package com.example.spring_community.dto.post;

public class UpdatePostResponse {
    private Long postId;

    public UpdatePostResponse(Long postId) {
        this.postId = postId;
    }

    public Long getPostId() {
        return postId;
    }
}
