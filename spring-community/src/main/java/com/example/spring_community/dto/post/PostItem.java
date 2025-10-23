package com.example.spring_community.dto.post;

import com.example.spring_community.dto.user.WriterInfo;

public class PostItem {
    private Long postId;
    private String title;
    private WriterInfo writer;
    private Statistic statistic;
    private String createdAt;

    public PostItem(Long postId, String title, WriterInfo writer, Statistic statistic, String createdAt) {
        this.postId = postId;
        this.title = title;
        this.writer = writer;
        this.statistic = statistic;
        this.createdAt = createdAt;
    }

    public Long getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public WriterInfo getWriter() {
        return writer;
    }

    public Statistic getStatistic() {
        return statistic;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
