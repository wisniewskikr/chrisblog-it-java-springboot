package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.grpc.DeleteResponseGrpc;
import com.example.grpc.DeleteServiceGrpc;
import com.example.services.UserService;

import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class DeleteController extends DeleteServiceGrpc.DeleteServiceImplBase {
	
	private UserService userService;
	
	@Autowired
	public DeleteController(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void delete(com.example.grpc.DeleteCommandGrpc commandGrpc,
        io.grpc.stub.StreamObserver<com.example.grpc.DeleteResponseGrpc> responseObserver) {
      
			userService.deleteById(commandGrpc.getId());
			DeleteResponseGrpc response = DeleteResponseGrpc.newBuilder().setMessage("Deleted").build();
			responseObserver.onNext(response);
            responseObserver.onCompleted();

    }

}