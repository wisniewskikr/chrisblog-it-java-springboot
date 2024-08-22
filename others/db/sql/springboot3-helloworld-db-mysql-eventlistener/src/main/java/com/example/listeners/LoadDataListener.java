package com.example.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.entities.HelloWorldEntity;
import com.example.services.HelloWorldService;

@Component
public class LoadDataListener {

    private HelloWorldService helloWorldService;

    @Autowired
    public LoadDataListener(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        helloWorldService.save(new HelloWorldEntity(1L, "Hello World!"));
    }

}