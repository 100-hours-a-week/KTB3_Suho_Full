package com.example.spring_community.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comment {
    private Long id;
    private Long postId;     // 어떤 게시글의 댓글인지
    private Long writerId;
    private String content;
    private String createdAt;

    public Comment(Long postId, Long writerId, String content, String createdAt) {
        this.postId = postId;
        this.writerId = writerId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Comment(Long id, Long postId, Long writerId, String content, String createdAt) {
        this.id = id;
        this.postId = postId;
        this.writerId = writerId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public void updateContent(String content) {
        this.content = content;
    }

    public void setId(Long id) {
        if(this.id != null) {
            throw new IllegalStateException("ID가 이미 할당되었습니다.");
        }
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getPostId() {
        return postId;
    }

    public Long getWriterId() {
        return writerId;
    }

    public String getContent() {
        return content;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
