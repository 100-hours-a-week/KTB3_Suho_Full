package com.example.spring_community.service;

import com.example.spring_community.domain.Comment;
import com.example.spring_community.dto.comment.RegisterCommentRequest;
import com.example.spring_community.dto.comment.UpdateCommentRequest;
import com.example.spring_community.repository.CommentRepository;
import com.example.spring_community.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public Long registerComment(Long postId, Long writerId, RegisterCommentRequest request) {
        if (!postRepository.existsById(postId)) {
            throw new NoSuchElementException("존재하지 않는 게시물입니다.");
        }

        String createdAt = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        Comment comment = new Comment(postId, writerId, request.getComment(), createdAt);
        return commentRepository.registerComment(comment);
    }

    public Long updateComment(Long postId, Long commentId, UpdateCommentRequest request) {
        if (!postRepository.existsById(postId)) {
            throw new NoSuchElementException("존재하지 않는 게시물입니다.");
        }
        if (!commentRepository.existsById(commentId)) {
            throw new NoSuchElementException("존재하지 않는 댓글입니다.");
        }

        Comment comment = commentRepository.getCommentById(commentId);
        comment.setContent(request.getComment());
        return comment.getId();
    }

    public void deleteComment(Long postId, Long commentId) {
        if (!postRepository.existsById(postId)) {
            throw new NoSuchElementException("존재하지 않는 게시물입니다.");
        }
        if (!commentRepository.existsById(commentId)) {
            throw new NoSuchElementException("존재하지 않는 댓글입니다.");
        }

        commentRepository.deleteComment(commentId);
    }
}