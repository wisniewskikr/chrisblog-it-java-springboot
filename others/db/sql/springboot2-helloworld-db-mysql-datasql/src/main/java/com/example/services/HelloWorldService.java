package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.HelloWorldEntity;
import com.example.repositories.HelloWorldRepository;

@Service
public class HelloWorldService {

    private HelloWorldRepository helloWorldRepository;

    @Autowired
    public HelloWorldService(HelloWorldRepository helloWorldRepository) {
        this.helloWorldRepository = helloWorldRepository;
    }

    public HelloWorldEntity findById(Long id) {
        return helloWorldRepository.findById(id).orElseThrow(() -> new RuntimeException("Message doesn't exist"));
    }

}