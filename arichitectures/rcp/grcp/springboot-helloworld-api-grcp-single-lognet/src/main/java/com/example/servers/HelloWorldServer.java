package com.example.servers;

import org.lognet.springboot.grpc.GRpcService;

import com.example.grpc.HelloWorldServiceGrpc;
import com.example.grpc.HelloWroldResponse;

@GRpcService
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
