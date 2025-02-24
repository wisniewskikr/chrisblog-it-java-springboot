package com.example.service;

import java.util.Collections;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    
    public Map<String, String> getResponse() {
        return Collections.singletonMap("message", "Hello World!");
    }

}