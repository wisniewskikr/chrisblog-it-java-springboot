package com.example.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import com.example.services.ApiService;

@RestController
public class HelloWorldController {

    private volatile List<String> results = new ArrayList<>();

    private ApiService apiService;

    public HelloWorldController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/")
    public String get() throws InterruptedException {                

        long startTime = System.currentTimeMillis();        

        apiService.callApi(results);
        apiService.callApi(results);
        apiService.callApi(results);

        CountDownLatch latch = new CountDownLatch(1);
        apiService.waitForResults(results, latch);
        latch.await();

        long endTime = System.currentTimeMillis();

        JSONObject json = new JSONObject();
        json.put("result", String.join(", ", results));
        json.put("duration in ms", (endTime - startTime));

        return json.toString();
        
    }

}
