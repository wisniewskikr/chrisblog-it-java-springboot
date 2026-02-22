package com.example.service;

import com.example.client.SecondClient;
import org.springframework.stereotype.Service;
import com.example.dto.HelloWorldDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HelloWorldService {
    
    private final SecondClient secondClient;

    public HelloWorldDto getMessage() {
        return secondClient.helloWorld();
    }

}