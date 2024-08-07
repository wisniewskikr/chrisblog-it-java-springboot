package com.example.servers;

import com.example.grpc.HelloWorldServiceGrpc;
import com.example.grpc.HelloWroldResponse;

import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloWorldServer extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {

    @Override
    public void getHelloWorld(com.example.grpc.HelloWorldRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.HelloWroldResponse> responseObserver) {
      
            String name = request.getName();
            HelloWroldResponse response = HelloWroldResponse.newBuilder().setMessage("Hello World " + name).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();

    }
    
}
