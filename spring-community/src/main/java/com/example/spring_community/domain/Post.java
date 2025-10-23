package com.example.spring_community.domain;

import java.util.Date;

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

    public Post(Long id, Long writerId, String title, String content, String postImageUrl,Long views, String createdAt) {
        this.id = id;
        this.writerId = writerId;
        this.title = title;
        this.content = content;
        this.postImageUrl = postImageUrl;
        this.views = views;
        this.createdAt = createdAt;
    }

    public void increaseViews() {
        this.views += 1;
    }

    public void updatePost(String title, String content, String postImageUrl) {
        this.title = title;
        this.content = content;
        this.postImageUrl = postImageUrl;
    }

    public void setId(Long id) {
        if(this.id != null) {
            throw new IllegalStateException("ID가 이미 할당되었습니다.");
        }
        this.id = id;
    }

    public Long getViews() {
        return views;
    }

    public Long getId() {
        return id;
    }

    public Long getWriterId() {
        return writerId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getPostImageUrl() {
        return postImageUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
