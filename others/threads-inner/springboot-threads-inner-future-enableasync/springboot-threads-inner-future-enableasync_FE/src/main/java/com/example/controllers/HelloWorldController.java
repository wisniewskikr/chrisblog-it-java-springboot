package com.example.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
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

        Future<Void> future1 = apiService.callApi(results);
        Future<Void> future2 = apiService.callApi(results);
        Future<Void> future3 = apiService.callApi(results);

        future1.get();
        future2.get();
        future3.get();

        long endTime = System.currentTimeMillis();

        JSONObject json = new JSONObject();
        json.put("result", String.join(", ", results));
        json.put("duration in ms", (endTime - startTime));

        return json.toString();
        
    }

}