package com.example.spring_community.dto.post;

public class Statistic {
    private Long likeCount;
    private Long viewCount;
    private Long commentCount;

    public Statistic(Long likeCount, Long viewCount, Long commentCount) {
        this.likeCount = likeCount;
        this.viewCount = viewCount;
        this.commentCount = commentCount;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }
}
