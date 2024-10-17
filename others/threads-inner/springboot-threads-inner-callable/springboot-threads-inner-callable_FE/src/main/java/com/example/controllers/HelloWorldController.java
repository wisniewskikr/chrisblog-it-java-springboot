package com.example.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

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
    public String get() throws InterruptedException {

        List<String> results = new ArrayList<>();        

        long startTime = System.currentTimeMillis();

        CountDownLatch latch = new CountDownLatch(3);

        apiService.callApi(results, latch);
        apiService.callApi(results, latch);
        apiService.callApi(results, latch);

        latch.await();

        long endTime = System.currentTimeMillis();

        JSONObject json = new JSONObject();
        json.put("result", String.join(", ", results));
        json.put("duration in ms", (endTime - startTime));

        return json.toString();
        
    }

}
