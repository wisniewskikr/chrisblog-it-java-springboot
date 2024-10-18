package com.example.services;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ApiService {

    private RestClient restClient;    

    public ApiService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl("http://localhost:8081").build();
    }
    
    public Callable<String> callApi() {        

        return () -> {

            return restClient.get()
                .uri("/" + Thread.currentThread().getName())
                .retrieve()
                .body(String.class);

        };

    }

}