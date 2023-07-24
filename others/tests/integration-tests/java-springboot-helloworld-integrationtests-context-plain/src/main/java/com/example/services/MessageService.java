package com.example.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Value("${helloworld.text}")
    private String message;

    public String getMessage() {
        return message;
    }
    
}
