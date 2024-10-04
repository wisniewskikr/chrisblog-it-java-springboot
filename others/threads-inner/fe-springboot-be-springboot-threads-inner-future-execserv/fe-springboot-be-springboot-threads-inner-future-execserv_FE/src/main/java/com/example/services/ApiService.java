package com.example.services;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ApiService {

    private RestClient restClient;    

    public ApiService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl("http://localhost:8081").build();
    }
    
    @Async
    public Future<Void> callApi(List<String> results) {        

                String result = restClient.get()
                    .uri("/" + Thread.currentThread().getName())
                    .retrieve()
                    .body(String.class);
                results.add(result); 

                return null;

    }

}