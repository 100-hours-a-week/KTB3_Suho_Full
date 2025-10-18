package com.example.spring_community.dto.post;

public class LikeToggleResponse {
    private Long likeId;

    public LikeToggleResponse(Long likeId) {
        this.likeId = likeId;
    }

    public Long getLikeId() {
        return likeId;
    }

    public void setLikeId(Long likeId) {
        this.likeId = likeId;
    }
}
