package com.example.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ApiService {

    private RestClient restClient;    

    public ApiService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl("http://localhost:8081").build();
    }
    
    public String callApi(String name) {
        
        return restClient.get()
                .uri("/" + name)
                .retrieve()
                .body(String.class);

    }

}