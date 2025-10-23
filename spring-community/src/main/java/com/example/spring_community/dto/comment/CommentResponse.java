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

    public Long getCommentId() {
        return commentId;
    }

}