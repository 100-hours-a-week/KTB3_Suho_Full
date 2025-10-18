package com.example.spring_community.dto.post;

public class LikeToggleRequest {
    private boolean isLiked;

    public LikeToggleRequest(boolean isLiked) {
        this.isLiked = isLiked;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }
}
