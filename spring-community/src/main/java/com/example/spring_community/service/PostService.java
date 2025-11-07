package com.example.spring_community.service;

import com.example.spring_community.domain.Comment;
import com.example.spring_community.domain.Post;
import com.example.spring_community.dto.comment.CommentItem;
import com.example.spring_community.dto.common.Pagination;
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

    public GetPostsResponse getPosts(int size, Long cursor) {
        List<PostItem> postItems = new ArrayList<>();
        List<Post> posts = postRepository.getPostsWithSize(size, cursor);
        for (Post post : posts) {
            try {
                WriterInfo writerInfo = userRepository.getWriterInfo(post.getWriterId());
                Statistic statistic = new Statistic(likeRepository.countByPostId(post.getId()), post.getViews(), commentRepository.countByPostId(post.getId()));
                PostItem postItem = new PostItem(post.getId(), post.getTitle(), writerInfo, statistic, post.getCreatedAt());
                postItems.add(postItem);
            } catch (Exception e) {
                System.out.println("PostService getPosts:: " + e.getMessage());
            }
        }
        Long lastCursor = posts.getLast().getId();
        Pagination pagination = new Pagination(size, postRepository.getHasNext(lastCursor), lastCursor);
        return new GetPostsResponse(postItems, pagination);
    }

    public Long registerPost(Long writerId, RegisterPostRequest request) {

            if (!userRepository.existsById(writerId)) {
                throw new NoSuchElementException("존재하지 않는 userId 입니다."); // 404 Error
            }

            Post post = new Post(
                    writerId,
                    request.getTitle(),
                    request.getContent(),
                    request.getImageUrl(),
                    getCurrentTime()
            );

            return postRepository.registerPost(post);

    }

    public DetailPostResponse getDetailPostById(Long postId) {
        throwPostNotFoundException(postId);

        Post post = postRepository.getPostById(postId);
        String createdAt = post.getCreatedAt();
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
        throwPostNotFoundException(postId);
        postRepository.updatePost(postId, request.getTitle(), request.getContent(), request.getPostImageUrl(), getCurrentTime());
        return postId;
    }

    private String getCurrentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public void deletePost(Long postId) {
        throwPostNotFoundException(postId);
        postRepository.deletePost(postId);
    }

    public Long toggleLike(Long postId, Long userId) {
        throwPostNotFoundException(postId);
        return likeRepository.likeToggle(postId, userId);
    }

    private void throwPostNotFoundException(Long postId) {
        if (!postRepository.existsById(postId)) {
            throw new NoSuchElementException("존재하지 않는 게시물입니다.");
        }
    }
}
