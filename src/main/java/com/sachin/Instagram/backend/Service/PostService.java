package com.sachin.Instagram.backend.Service;

import com.sachin.Instagram.backend.model.Post;
import com.sachin.Instagram.backend.model.User;
import com.sachin.Instagram.backend.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;


@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public Post savePost(Post post) {
        User user = userService.getUser(post.getUser().getId());
        post.setUser(user);
        return postRepository.save(post);
    }

    public Post getPost(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new NoSuchElementException("Post not found"));
    }

    public Post updatePost(Long postId, Post postDetails) {
        Post existingPost = getPost(postId);
        existingPost.setPostData(postDetails.getPostData());
        existingPost.setUpdatedDate(LocalDateTime.now());
        return postRepository.save(existingPost);
    }


    public User getPostUser(Long postId) {
        Post post = getPost(postId);
        return post.getUser();
    }
}
