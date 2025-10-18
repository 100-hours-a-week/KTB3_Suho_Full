package com.example.spring_community.domain;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getWriterId() {
        return writerId;
    }

    public void setWriterId(Long writerId) {
        this.writerId = writerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
