package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.example.dtos.HelloWorldDto;
import com.example.entities.HelloWorldEntity;
import com.example.repositories.HelloWorldRepository;

@Service
public class HelloWorldService {

    private HelloWorldRepository helloWorldRepository;
    private Environment environment;

    @Autowired
    public HelloWorldService(HelloWorldRepository helloWorldRepository, Environment environment) {
        this.helloWorldRepository = helloWorldRepository;
        this.environment = environment;
    }

    public HelloWorldDto findById(Long id) {
        
        HelloWorldEntity helloWorldEntity = helloWorldRepository.findById(id).orElseThrow(() -> new RuntimeException("Message doesn't exist"));
        String portBe = environment.getProperty("local.server.port");
        return new HelloWorldDto(helloWorldEntity.getId(), helloWorldEntity.getText(), idBe, portBe);

    }

}