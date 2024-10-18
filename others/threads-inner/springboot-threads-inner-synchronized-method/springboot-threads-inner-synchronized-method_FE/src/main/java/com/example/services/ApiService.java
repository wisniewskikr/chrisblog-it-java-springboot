package com.example.services;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ApiService {

    private RestClient restClient;    

    public ApiService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl("http://localhost:8081").build();
    }
    
    public void callApi(List<String> results, CountDownLatch latch) {

        Runnable task = () -> {

                String result = getMessage();
                results.add(result); 
                latch.countDown();      

        };
        
        Thread thread = new Thread(task);
        thread.start();        

    }

    private synchronized String getMessage() {

        return restClient.get()
                    .uri("/" + Thread.currentThread().getName())
                    .retrieve()
                    .body(String.class);

    }

}