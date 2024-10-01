package com.example.controllers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.springframework.web.bind.annotation.*;

import com.example.services.ApiService;

@RestController
public class HelloWorldController {

    private final ExecutorService executorService;
    private final ApiService apiService;

    public HelloWorldController(ExecutorService executorService, ApiService apiService) {
        this.executorService = executorService;
        this.apiService = apiService;
    }

    @GetMapping("/")
    public String get() {

        try {
            Future<String> futureResult = executorService.submit(apiService.callApi());
            return futureResult.get();            
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to execute task";
        }        
        
    }

}
