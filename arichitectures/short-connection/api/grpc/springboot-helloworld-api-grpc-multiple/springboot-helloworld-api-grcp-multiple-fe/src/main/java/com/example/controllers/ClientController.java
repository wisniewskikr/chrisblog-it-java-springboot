package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.grpc.HelloWorldRequest;
import com.example.grpc.HelloWorldServiceGrpc;
import com.example.grpc.HelloWroldResponse;

import io.grpc.ManagedChannel;

@RestController
public class ClientController {

    private ManagedChannel managedChannel;

    @Autowired
    public ClientController(ManagedChannel managedChannel) {
        this.managedChannel = managedChannel;
    }

    @GetMapping("/")
    public String displayStranger() {

        HelloWorldServiceGrpc.HelloWorldServiceBlockingStub blockingStub = HelloWorldServiceGrpc.newBlockingStub(managedChannel);
        HelloWroldResponse response = blockingStub.getHelloWorld(HelloWorldRequest.newBuilder().setName("Stranger").build());
        return response.getMessage();
        
    }

    @GetMapping("/name/{name}")
    public String displayName(@PathVariable String name) {

        HelloWorldServiceGrpc.HelloWorldServiceBlockingStub blockingStub = HelloWorldServiceGrpc.newBlockingStub(managedChannel);
        HelloWroldResponse response = blockingStub.getHelloWorld(HelloWorldRequest.newBuilder().setName(name).build());
        return response.getMessage();
        
    }
    
}