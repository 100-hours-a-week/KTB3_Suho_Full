package com.example.spring_community.repository;

import com.example.spring_community.domain.Comment;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CommentRepository {
    private Map<Long, Comment> comments;
    private Long sequence = 1L;

    public CommentRepository() {
        comments = new HashMap<>();
        initData();
    }
    private void initData() {
        registerComment(new Comment(1L, 1L, "댓글입니다.","2000-01-01 00:00:00"));
        registerComment(new Comment(1L, 2L, "댓글입니다 22.","2000-01-01 00:00:00"));
    }
    public CommentRepository(Map<Long, Comment> comments) {
        this.comments = comments;
    }

    public Long registerComment(Comment comment) {
        if (comment.getId() == null) {
            while(existsById(sequence)) {
                sequence++;
            }
            comment.setId(sequence);
        }
        comments.put(comment.getId(), comment);
        return comment.getId();
    }

    public boolean existsById(Long id) {
        return comments.containsKey(id);
    }

    public Long countByPostId(Long postId) {
        return comments.values().stream()
                .filter(comment -> comment.getPostId().equals(postId))
                .count();
    }

    public List<Comment> getCommentByPostId(Long postId) {
        return comments.values().stream().filter(comment -> comment.getPostId().equals(postId)).toList();
    }

    public Comment getCommentById(Long commentId) {
        return comments.get(commentId);
    }

    public void updateContent(Long commentId, String content) {
        comments.get(commentId).updateContent(content);
    }

    public void deleteComment(Long commentId) {
        comments.remove(commentId);
    }
}
