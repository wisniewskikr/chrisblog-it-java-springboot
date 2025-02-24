package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import com.example.dto.HelloWorldDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HelloWorldService {
    
    private final RestClient restClient;

    public HelloWorldDto getMessage() {

        return restClient.get()
                .uri("/message")
                .retrieve()
                .body(HelloWorldDto.class);

    }

}