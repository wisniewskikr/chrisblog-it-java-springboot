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
    
    public void callApi(List<String> results) {

        Runnable task = () -> {

                String result = restClient.get()
                    .uri("/" + Thread.currentThread().getName())
                    .retrieve()
                    .body(String.class);
                results.add(result); 

        };
        
        Thread thread = new Thread(task);
        thread.start();        

    }

    public void waitForResults(List<String> results, CountDownLatch latch) {

        Runnable task = () -> {

            while (results.size() != 3) {                
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            latch.countDown();      

        };
        
        Thread thread = new Thread(task);
        thread.start(); 

    }

}