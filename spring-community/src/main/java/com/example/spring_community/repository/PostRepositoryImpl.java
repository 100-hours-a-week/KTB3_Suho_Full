package com.example.spring_community.repository;

import com.example.spring_community.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepositoryImpl implements PostRepository {
    private Map<Long, Post> posts;
    private Long sequence = 1L;

    public PostRepositoryImpl() {
        posts = new HashMap<>();
        initData();
    }

    private void initData() {
        registerPost(new Post(1L, "제목 1", "내용입니다.", "이미지.jpg", "2000-01-01 00:00:00"));
        registerPost(new Post(2L, "제목 2", "내용입니다.", "이미지.jpg", "2000-01-01 00:00:00"));
        registerPost(new Post(3L, "제목 3", "내용입니다.", "이미지.jpg", "2000-01-01 00:00:00"));

    }

    public PostRepositoryImpl(Map<Long, Post> posts) {
        this.posts = posts;
    }

    @Override
    public Post getPostById(Long postId) {
        Post post = posts.get(postId);
        post.increaseViews();
        return post;
    }

    @Override
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

    @Override
    public void deletePost(Long id) {
        if (existsById(id)) {
            posts.remove(id);
        }
    }

    @Override
    public Collection<Post> getPosts() {
        return posts.values();
    }

    @Override
    public void updatePost(Long id, String title, String content, String postImageUrl, String updatedAt) {
        if (existsById(id)) {
            Post post = posts.get(id);
            post.updatePost(title, content, postImageUrl);
        }
    }

    @Override
    public List<Post> getPostsWithSize(int size, Long cursor) {
        return posts.values().stream().filter(post -> post.getId() >= cursor)
                .sorted((p1, p2) -> Long.compare(p1.getId(), p2.getId()))
                .limit(size).toList();
    }

    @Override
    public boolean getHasNext(Long cursor) {
        return !posts.values().stream().filter(post -> post.getId() > cursor).toList().isEmpty();
    }

    @Override
    public boolean existsById(Long id) {
        return posts.containsKey(id);
    }
}