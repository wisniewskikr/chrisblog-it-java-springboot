package com.example.controller;

import org.springframework.web.bind.annotation.*;

import com.example.dao.Post;
import com.example.service.PostService;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    Post findById() {
        return postService.findById(1L);
    }

}
