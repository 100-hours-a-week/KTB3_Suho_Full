package com.example.spring_community.dto.comment;

public class CommentResponse {
    private Long postId;
    private Long commentId;

    public CommentResponse(Long postId, Long commentId) {
        this.postId = postId;
        this.commentId = commentId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }
}