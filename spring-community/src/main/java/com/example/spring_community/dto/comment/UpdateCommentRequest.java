package com.example.spring_community.dto.comment;

public class UpdateCommentRequest {
    private String comment;

    public UpdateCommentRequest(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

}