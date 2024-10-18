package com.example.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import com.example.services.ApiService;

@RestController
public class HelloWorldController {

    private ApiService apiService;

    public HelloWorldController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/")
    public String get() throws InterruptedException, ExecutionException {

        List<String> results = new ArrayList<>();        

        long startTime = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        
        CompletableFuture<String> future1 = apiService.callApi(executorService);
        CompletableFuture<String> future2 = apiService.callApi(executorService);
        CompletableFuture<String> future3 = apiService.callApi(executorService);

        CompletableFuture.allOf(future1, future2, future3).join();

        results.add(future1.get());
        results.add(future2.get());
        results.add(future3.get());
        
        executorService.shutdown();

        long endTime = System.currentTimeMillis();

        JSONObject json = new JSONObject();
        json.put("result", String.join(", ", results));
        json.put("duration in ms", (endTime - startTime));

        return json.toString();
        
    }

}
