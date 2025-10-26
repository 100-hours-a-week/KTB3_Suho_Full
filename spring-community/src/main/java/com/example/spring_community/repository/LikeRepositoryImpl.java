package com.example.spring_community.repository;


import com.example.spring_community.domain.Like;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LikeRepositoryImpl implements LikeRepository {
    private Map<Long, Like> likes;
    private Long sequence = 1L;

    public LikeRepositoryImpl() {
        likes = new HashMap<>();
        initData();
    }

    private void initData() {
        registerLike(new Like(1L, 1L));
        registerLike(new Like(1L, 2L));
        registerLike(new Like(1L, 3L));

        registerLike(new Like(2L, 1L));
        registerLike(new Like(2L, 2L));

        registerLike(new Like(3L, 1L));
    }

    @Override
    public Long countByPostId(Long postId) {
        return likes.values().stream().filter(like -> like.getPostId().equals(postId)).count();
    }

    @Override
    public Like registerLike(Like like) {
        if (like.getId() == null) {
            while (existsById(sequence)) {
                sequence++;
            }
            like.setId(sequence);
        }
        likes.put(like.getId(), like);
        return like;
    }

    @Override
    public boolean isLikedPostByUserId(Long postId, Long userId) {
        for (Map.Entry<Long, Like> entry : likes.entrySet()) {
            if (entry.getValue().getPostId().equals(postId) && entry.getValue().getUserId().equals(userId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existsById(Long id) {
        return likes.containsKey(id);
    }

    @Override
    public void removeLike(Long likeId) {
        likes.remove(likeId);
    }

    @Override
    public Long likeToggle(Long postId, Long userId) {
        for (Map.Entry<Long, Like> entry : likes.entrySet()) {
            if (entry.getValue().getPostId().equals(postId) && entry.getValue().getUserId().equals(userId)) {
                removeLike(entry.getKey());
                return null;
            }
        }
        return registerLike(new Like(postId, userId)).getId();
    }
}

