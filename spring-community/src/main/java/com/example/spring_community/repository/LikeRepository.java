package com.example.spring_community.repository;

import com.example.spring_community.domain.Like;

public interface LikeRepository {

    Long countByPostId(Long postId);

    Like registerLike(Like like);

    boolean isLikedPostByUserId(Long postId, Long userId);

    boolean existsById(Long id);

    void removeLike(Long likeId);

    Long likeToggle(Long postId, Long userId);
}
