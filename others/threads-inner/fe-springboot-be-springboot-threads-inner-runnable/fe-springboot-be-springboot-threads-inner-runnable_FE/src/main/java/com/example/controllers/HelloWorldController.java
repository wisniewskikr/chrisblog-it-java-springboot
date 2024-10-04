package com.example.controllers;

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
    public String get() {

        long startTime = System.currentTimeMillis();

        String result1 = apiService.callApi(Thread.currentThread().getName());
        String result2 = apiService.callApi(Thread.currentThread().getName());
        String result3 = apiService.callApi(Thread.currentThread().getName());

        long endTime = System.currentTimeMillis();

        JSONObject json = new JSONObject();
        json.put("result", result1 + " | " + result2 + " | " + result3);
        json.put("duration in ms", (endTime - startTime));

        return json.toString();
        
    }

}
