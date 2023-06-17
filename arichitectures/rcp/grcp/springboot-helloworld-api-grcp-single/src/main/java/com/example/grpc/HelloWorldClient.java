package com.example.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloWorldClient {

    public static void main(String[] args) {
        
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();

        HelloWorldServiceGrpc.HelloWorldServiceBlockingStub blockingStub = HelloWorldServiceGrpc.newBlockingStub(managedChannel);
        HelloWroldResponse response = blockingStub.getHelloWorld(HelloWorldRequest.newBuilder().setName("Chris").build());
        System.out.println(response.getMessage());

    }
    
}
