package com.example.services;

import java.util.List;
import java.util.concurrent.Callable;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ApiService {

    private RestClient restClient;    

    public ApiService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl("http://localhost:8081").build();
    }
    
    public Runnable callApi(List<String> results) {        

        return () -> {

            String result = restClient.get()
                .uri("/" + Thread.currentThread().getName())
                .retrieve()
                .body(String.class);
            results.add(result); 

        };

    }

}