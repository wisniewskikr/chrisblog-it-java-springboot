package com.example.controllers;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

@RestController
public class HelloWorldController {

    private RestClient restClient;    

    public HelloWorldController(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl("http://localhost:8081").build();
    }

    @GetMapping("/")
    public String get() throws InterruptedException, ExecutionException {

        String result = null;

        ExecutorService executorService = Executors.newFixedThreadPool(200);

        Future<String> future = executorService.submit(
            new Callable<String>() {

                @Override
                public String call() throws Exception {
                    return restClient.get()
                        .uri("/")
                        .retrieve()
                        .body(String.class);
                }
                
            }

        );

        result = future.get();

        executorService.shutdown();

        return result;
        
    }

}
