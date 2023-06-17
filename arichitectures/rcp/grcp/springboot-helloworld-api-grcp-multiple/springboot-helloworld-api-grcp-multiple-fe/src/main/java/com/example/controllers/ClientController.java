package com.example.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.grpc.HelloWorldRequest;
import com.example.grpc.HelloWorldServiceGrpc;
import com.example.grpc.HelloWroldResponse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@RestController
public class ClientController {

    @Value("${grpc.address.name}")
    private String addressName;

    @Value("${grpc.address.port}")
    private int addressPort;

    @GetMapping("/")
    public String displayStranger() {

        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress(addressName, addressPort).usePlaintext().build();
        HelloWorldServiceGrpc.HelloWorldServiceBlockingStub blockingStub = HelloWorldServiceGrpc.newBlockingStub(managedChannel);
        HelloWroldResponse response = blockingStub.getHelloWorld(HelloWorldRequest.newBuilder().setName("Stranger").build());
        return response.getMessage();
        
    }

    @GetMapping("/name/{name}")
    public String displayName(@PathVariable String name) {

        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress(addressName, addressPort).usePlaintext().build();
        HelloWorldServiceGrpc.HelloWorldServiceBlockingStub blockingStub = HelloWorldServiceGrpc.newBlockingStub(managedChannel);
        HelloWroldResponse response = blockingStub.getHelloWorld(HelloWorldRequest.newBuilder().setName(name).build());
        return response.getMessage();
        
    }
    
}
