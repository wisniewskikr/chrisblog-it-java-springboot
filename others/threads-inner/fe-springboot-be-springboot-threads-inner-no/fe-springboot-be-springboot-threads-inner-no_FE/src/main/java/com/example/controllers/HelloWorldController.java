package com.example.controllers;

import java.util.List;
import java.util.ArrayList;

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

        List<String> results = new ArrayList<>(); 

        long startTime = System.currentTimeMillis();

        apiService.callApi(results);
        apiService.callApi(results);
        apiService.callApi(results);

        long endTime = System.currentTimeMillis();

        JSONObject json = new JSONObject();
        json.put("result", String.join(", ", results));
        json.put("duration in ms", (endTime - startTime));

        return json.toString();
        
    }

}
