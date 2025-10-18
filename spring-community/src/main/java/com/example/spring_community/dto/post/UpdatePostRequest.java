package com.example.spring_community.dto.post;

public class UpdatePostRequest {
    private String title;
    private String content;
    private String postImageUrl;

    public UpdatePostRequest(String title, String content, String postImageUrl) {
        this.title = title;
        this.content = content;
        this.postImageUrl = postImageUrl;
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
}
