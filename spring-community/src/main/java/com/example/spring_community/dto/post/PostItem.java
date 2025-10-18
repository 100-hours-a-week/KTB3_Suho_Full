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

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public WriterInfo getWriter() {
        return writer;
    }

    public void setWriter(WriterInfo writer) {
        this.writer = writer;
    }

    public Statistic getStatistic() {
        return statistic;
    }

    public void setStatistic(Statistic statistic) {
        this.statistic = statistic;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
