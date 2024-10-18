package com.example.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
        
        Future<String> future1 = executorService.submit(apiService.callApi());
        Future<String> future2 = executorService.submit(apiService.callApi());
        Future<String> future3 = executorService.submit(apiService.callApi());

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
