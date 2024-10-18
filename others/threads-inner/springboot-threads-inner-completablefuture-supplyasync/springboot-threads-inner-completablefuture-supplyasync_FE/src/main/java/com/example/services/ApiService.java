package com.example.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ApiService {

    private RestClient restClient;    

    public ApiService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl("http://localhost:8081").build();
    }
    
    public CompletableFuture<String> callApi(ExecutorService executor) {
        
        return CompletableFuture.supplyAsync(() -> {

            return restClient.get()
                .uri("/" + Thread.currentThread().getName())
                .retrieve()
                .body(String.class);
             
        }, executor);

    }

}