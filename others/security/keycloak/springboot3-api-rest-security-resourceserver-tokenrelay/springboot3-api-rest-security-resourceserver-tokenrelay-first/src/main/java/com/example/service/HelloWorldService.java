package com.example.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import com.example.dto.HelloWorldDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HelloWorldService {
    
    private final RestClient restClient;

    public HelloWorldDto getMessage() {

        Jwt jwt = (Jwt)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return restClient.get()
                .uri("/message")
                .header("Authorization", "Bearer " + jwt.getTokenValue())
                .retrieve()
                .body(HelloWorldDto.class);

    }

}