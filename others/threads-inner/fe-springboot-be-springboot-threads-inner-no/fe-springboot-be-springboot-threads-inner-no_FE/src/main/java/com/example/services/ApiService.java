package com.example.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.util.List;

@Service
public class ApiService {

    private RestClient restClient;    

    public ApiService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl("http://localhost:8081").build();
    }
    
    public void callApi(List<String> results) {
        
        String result = restClient.get()
                .uri("/" + Thread.currentThread().getName())
                .retrieve()
                .body(String.class);
        results.add(result);

    }

}