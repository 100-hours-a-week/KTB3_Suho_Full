package com.example.spring_community.domain;

public class Like {


    private Long id;
    private final Long postId;
    private final Long userId;

    public Like(Long postId, Long userId) {
        this.postId = postId;
        this.userId = userId;
    }
    public Like(Long id, Long postId, Long userId) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
    }
    public void setId(Long id) {
        if (this.id != null) {
            throw new  IllegalStateException("이미 ID를 할당 되었습니다.");
        }
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getPostId() {
        return postId;
    }

    public Long getUserId() {
        return userId;
    }

}
