package com.example.spring_community.repository;

import com.example.spring_community.domain.Post;
import com.example.spring_community.dto.post.PostItem;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Repository
public class PostRepository {
    private Map<Long, Post> posts;
    private Long sequence = 1L;

    public PostRepository() {
        posts = new HashMap<>();
        initData();
    }

    private void initData() {
        registerPost(new Post(1L, "제목 1", "내용입니다.", "이미지.jpg", "2000-01-01 00:00:00"));
        registerPost(new Post(2L, "제목 2", "내용입니다.", "이미지.jpg", "2000-01-01 00:00:00"));
        registerPost(new Post(3L, "제목 3", "내용입니다.", "이미지.jpg", "2000-01-01 00:00:00"));

    }

    public PostRepository(Map<Long, Post> posts) {
        this.posts = posts;
    }

    public Post getPostById(Long postId) {
        Post post = posts.get(postId);
        post.setViews(post.getViews() + 1);
        return post;
    }

    public Long registerPost(Post post) {
        if (post.getId() == null) {
            while (existsById(sequence)) {
                sequence++;
            }
            post.setId(sequence);
        }
        posts.put(post.getId(), post);
        return post.getId();
    }

    public void deletePost(Long id) {
        if (existsById(id)) {
            posts.remove(id);
        }
    }

    public Collection<Post> getPosts() {
        return posts.values();
    }

    public void updatePost(Long id, String title, String content, String postImageUrl) {
        if (existsById(id)) {
            Post post = posts.get(id);
            post.setTitle(title);
            post.setContent(content);
            post.setPostImageUrl(postImageUrl);
        }
    }

    public boolean existsById(Long id) {
        return posts.containsKey(id);
    }
}
