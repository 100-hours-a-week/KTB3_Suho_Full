package com.example.spring_community.dto.post;

public class DetailStatistic {
    private Long likeCount;
    private Long commentCount;
    private Long viewCount;
    private Boolean isLiked;

    public DetailStatistic(Long likeCount, Long commentCount, Long viewCount, Boolean isLiked) {
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.viewCount = viewCount;
        this.isLiked = isLiked;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public Boolean getIsLiked() {
        return isLiked;
    }
}