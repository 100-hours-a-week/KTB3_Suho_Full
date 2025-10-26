package com.example.spring_community.repository;

import com.example.spring_community.domain.Comment;

import java.util.List;

public interface CommentRepository {
    Long registerComment(Comment comment);
    boolean existsById(Long id);
    Long countByPostId(Long postId);

    List<Comment> getCommentByPostId(Long postId);

    void updateContent(Long commentId, String content);

    void deleteComment(Long commentId);
}
