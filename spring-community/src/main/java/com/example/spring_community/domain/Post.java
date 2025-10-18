package com.example.spring_community.domain;

public class Post {
    private Long id;
    private Long writerId;
    private String title;
    private String content;
    private String postImageUrl;
    private Long views;
    private String createdAt;

    public Post(Long writerId, String title, String content, String postImageUrl, String createdAt) {
        this.writerId = writerId;
        this.title = title;
        this.content = content;
        this.postImageUrl = postImageUrl;
        this.createdAt = createdAt;
        this.views = 0L;
    }

    public Post(Long writerId, String title, String content, String postImageUrl, Long views, String createdAt) {
        this.writerId = writerId;
        this.title = title;
        this.content = content;
        this.postImageUrl = postImageUrl;
        this.views = views;
        this.createdAt = createdAt;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWriterId() {
        return writerId;
    }

    public void setWriterId(Long writerId) {
        this.writerId = writerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostImageUrl() {
        return postImageUrl;
    }

    public void setPostImageUrl(String postImageUrl) {
        this.postImageUrl = postImageUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
