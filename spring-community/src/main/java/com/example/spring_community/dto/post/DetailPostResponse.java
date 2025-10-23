package com.example.spring_community.dto.post;

import com.example.spring_community.dto.comment.CommentItem;
import com.example.spring_community.dto.user.WriterInfo;

import java.util.List;

public class DetailPostResponse {
    private Long postId;
    private String title;
    private String content;
    private String postImageUrl;
    private String createdAt;
    private WriterInfo writer;
    private DetailStatistic statistics;
    private List<CommentItem> comments;

    public DetailPostResponse(Long postId, String title, String content, String postImageUrl,
                              String createdAt, WriterInfo writer, DetailStatistic statistics,
                              List<CommentItem> comments) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.postImageUrl = postImageUrl;
        this.createdAt = createdAt;
        this.writer = writer;
        this.statistics = statistics;
        this.comments = comments;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
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

    public WriterInfo getWriter() {
        return writer;
    }

    public DetailStatistic getStatistics() {
        return statistics;
    }

    public List<CommentItem> getComments() {
        return comments;
    }
}