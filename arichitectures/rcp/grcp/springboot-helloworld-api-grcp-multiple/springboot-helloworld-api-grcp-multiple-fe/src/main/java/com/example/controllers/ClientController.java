package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.grpc.HelloWorldRequest;
import com.example.grpc.HelloWorldServiceGrpc;
import com.example.grpc.HelloWroldResponse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@RestController
public class ClientController {

    @GetMapping("/")
    public String displayStranger() {

        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();

        HelloWorldServiceGrpc.HelloWorldServiceBlockingStub blockingStub = HelloWorldServiceGrpc.newBlockingStub(managedChannel);
        HelloWroldResponse response = blockingStub.getHelloWorld(HelloWorldRequest.newBuilder().setName("Stranger").build());
        return response.getMessage();
        
    }
    
}
