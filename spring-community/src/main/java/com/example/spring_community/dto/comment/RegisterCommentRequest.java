package com.example.spring_community.dto.comment;

public class RegisterCommentRequest {
    private String comment;

    public RegisterCommentRequest(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
