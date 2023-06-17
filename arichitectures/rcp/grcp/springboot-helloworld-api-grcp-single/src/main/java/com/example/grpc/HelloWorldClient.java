package com.example.grpc;

import com.anubhav.grpc.StudentRequest;
import com.anubhav.grpc.StudentResponse;
import com.anubhav.grpc.StudentServiceGrpc;
import com.example.grpc.HelloWorldRequest;
import com.example.grpc.HelloWorldServiceGrpc;
import com.example.grpc.HelloWroldResponse;
import com.example.grpc.HelloWorldServiceGrpc.HelloWorldServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloWorldClient {

    public static void main(String[] args) {
        
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();

        HelloWorldServiceGrpc.HelloWorldServiceBlockingStub blockingStub = HelloWorldServiceGrpc.newBlockingStub(managedChannel);
        HelloWroldResponse response = blockingStub.getHelloWorld(HelloWorldRequest.newBuilder().setName("Chris").build());
        System.out.println(response.getMessage());

        // StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);
        // StudentResponse response = blockingStub.getStudent(StudentRequest.newBuilder().setId(1).build());
        // System.out.println(response.getName());

    }
    
}
