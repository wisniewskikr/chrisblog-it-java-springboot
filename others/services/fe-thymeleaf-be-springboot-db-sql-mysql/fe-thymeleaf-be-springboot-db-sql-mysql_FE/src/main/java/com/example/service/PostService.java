package com.example.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.dao.Post;

import java.util.List;

@Service
public class PostService {

    private final RestClient restClient;

    public PostService() {
        restClient = RestClient.builder()
                .baseUrl("http://localhost:8081")
                .build();
    }

    public Post findById(Long id) {
        return restClient.get()
                .uri("/message/{id}", id)
                .retrieve()
                .body(Post.class);
    }

}
