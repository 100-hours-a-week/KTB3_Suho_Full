package com.example.spring_community.dto.post;

public class RegisterPostRequest {
    private String title;
    private String content;
    private String imageUrl;

    public RegisterPostRequest(String title, String content, String imageUrl) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
