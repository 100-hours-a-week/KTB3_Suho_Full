package com.example.spring_community.repository;

import com.example.spring_community.domain.Post;
import com.example.spring_community.dto.common.Pagination;
import com.example.spring_community.dto.post.GetPostsResponse;
import com.example.spring_community.dto.post.PostItem;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

public interface PostRepository {
    Post getPostById(Long postId);

    Long registerPost(Post post);

    void deletePost(Long id);

    Collection<Post> getPosts();

    void updatePost(Long id, String title, String content, String postImageUrl, String updatedAt);

    List<Post> getPostsWithSize(int size, Long cursor);

    boolean getHasNext(Long cursor);

    boolean existsById(Long id);
}
