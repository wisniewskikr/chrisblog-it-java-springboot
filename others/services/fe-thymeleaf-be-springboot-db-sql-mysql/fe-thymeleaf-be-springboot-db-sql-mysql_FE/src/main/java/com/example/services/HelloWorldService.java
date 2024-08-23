package com.example.services;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.dtos.HelloWorldDto;

import java.util.List;

@Service
public class HelloWorldService {

    private final RestClient restClient;

    public HelloWorldService() {
        restClient = RestClient.builder()
                .baseUrl("http://localhost:8081")
                .build();
    }

    public HelloWorldDto findById(Long id) {
        return restClient.get()
                .uri("/message/{id}", id)
                .retrieve()
                .body(HelloWorldDto.class);
    }

}
