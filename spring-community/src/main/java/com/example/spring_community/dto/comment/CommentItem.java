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

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public WriterInfo getWriter() {
        return writer;
    }

    public void setWriter(WriterInfo writer) {
        this.writer = writer;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}