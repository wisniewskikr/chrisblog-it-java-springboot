package com.example.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

@RestController
public class HelloWorldController {

    private RestClient restClient;    

    public HelloWorldController(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl("http://localhost:8081").build();
    }

    @GetMapping("/")
    public String get() {
        return restClient.get()
                .uri("/")
                .retrieve()
                .body(String.class);
    }

}
