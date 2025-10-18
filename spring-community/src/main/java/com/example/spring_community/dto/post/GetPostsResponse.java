package com.example.spring_community.dto.post;

import com.example.spring_community.domain.Post;
import com.example.spring_community.dto.common.Pagination;

import java.util.List;

public class GetPostsResponse {
    private List<PostItem> posts;
    private Pagination pagination;

    public GetPostsResponse(List<PostItem> posts, Pagination pagination) {
        this.posts = posts;
        this.pagination = pagination;
    }

    public List<PostItem> getPosts() {
        return posts;
    }

    public void setPosts(List<PostItem> posts) {
        this.posts = posts;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
