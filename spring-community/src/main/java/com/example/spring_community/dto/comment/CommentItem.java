package com.example.spring_community.dto.comment;

import com.example.spring_community.dto.user.WriterInfo;

public class CommentItem {
    private Long commentId;
    private String content;
    private WriterInfo writer;
    private String createdAt;

    public CommentItem(Long commentId, String content, WriterInfo writer, String createdAt) {
        this.commentId = commentId;
        this.content = content;
        this.writer = writer;
        this.createdAt = createdAt;
    }

    public Long getCommentId() {
        return commentId;
    }

    public String getContent() {
        return content;
    }

    public WriterInfo getWriter() {
        return writer;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}