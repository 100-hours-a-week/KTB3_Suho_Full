package com.example.spring_community.service;

import com.example.spring_community.domain.Comment;
import com.example.spring_community.domain.Post;
import com.example.spring_community.dto.comment.CommentItem;
import com.example.spring_community.dto.post.*;
import com.example.spring_community.dto.user.WriterInfo;
import com.example.spring_community.repository.CommentRepository;
import com.example.spring_community.repository.LikeRepository;
import com.example.spring_community.repository.PostRepository;
import com.example.spring_community.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final LikeRepository likeRepository;
    private final CommentRepository commentRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository, LikeRepository likeRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.likeRepository = likeRepository;
        this.commentRepository = commentRepository;
    }

    public List<PostItem> getPosts() {
        Collection<Post> posts = postRepository.getPosts();
        List<PostItem> postItems = new ArrayList<>();
        for (Post post : posts) {
            try {
                WriterInfo writerInfo = userRepository.getWriterInfo(post.getWriterId());
                Statistic statistic = new Statistic(likeRepository.countByPostId(post.getId()), post.getViews(), commentRepository.countByPostId(post.getId()));
                PostItem postItem = new PostItem(post.getId(), post.getTitle(), writerInfo, statistic, post.getCreatedAt());
                postItems.add(postItem);
            } catch (Exception e) {
                continue;
            }
        }
        return postItems;
    }

    public Long registerPost(Long writerId, RegisterPostRequest request) {

            if (!userRepository.existsById(writerId)) {
                throw new NoSuchElementException("존재하지 않는 userId 입니다."); // 404 Error
            }

            String createdAt = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            Post post = new Post(
                    writerId,
                    request.getTitle(),
                    request.getContent(),
                    request.getImageUrl(),
                    createdAt
            );

            return postRepository.registerPost(post);

    }

    public Post getPostById(Long postId) {
        if (!postRepository.existsById(postId)) {
            throw new NoSuchElementException("존재하지 않는 postId 입니다."); // 404 Error
        }
        return postRepository.getPostById(postId);
    }

    public DetailPostResponse getDetailPostById(Long postId) {
        if (!postRepository.existsById(postId)) {
            throw new NoSuchElementException("존재하지 않는 postId 입니다."); // 404 Error
        }
        Post post = postRepository.getPostById(postId);
        String createdAt = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        WriterInfo writer = userRepository.getWriterInfo(post.getWriterId());
        DetailStatistic statistic = new DetailStatistic(
            likeRepository.countByPostId(post.getId()),
            commentRepository.countByPostId(post.getId()),
            post.getViews(),
            likeRepository.isLikedPostByUserId(postId, 1L)
        );
        List<Comment> comments = commentRepository.getCommentByPostId(postId);
        List<CommentItem> commentItems = new ArrayList<>();
        for (Comment comment : comments) {
            WriterInfo writerInfo = userRepository.getWriterInfo(comment.getWriterId());
            CommentItem commentItem = new CommentItem(comment.getId(), comment.getContent(), writerInfo, comment.getCreatedAt());
            commentItems.add(commentItem);
        }
        return new DetailPostResponse(postId, post.getTitle(), post.getContent(), post.getPostImageUrl(), createdAt, writer, statistic, commentItems);
    }

    public Long updatePost(Long postId, UpdatePostRequest request) {
        if (!postRepository.existsById(postId)) {
            throw new NoSuchElementException("존재하지 않는 게시물입니다."); // 404 Error
        }
        Post post = postRepository.getPostById(postId);
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setPostImageUrl(request.getPostImageUrl());
        return post.getId();
    }

    public void deletePost(Long postId) {
        if (!postRepository.existsById(postId)) {
            throw new NoSuchElementException("존재하지 않는 게시물입니다.");
        }
        postRepository.deletePost(postId);
    }

    public Long toggleLike(Long postId, Long userId) {
        if (!postRepository.existsById(postId)) {
            throw new NoSuchElementException("존재하지 않는 게시물입니다.");
        }
        return likeRepository.likeToggle(postId, userId);
    }
}
