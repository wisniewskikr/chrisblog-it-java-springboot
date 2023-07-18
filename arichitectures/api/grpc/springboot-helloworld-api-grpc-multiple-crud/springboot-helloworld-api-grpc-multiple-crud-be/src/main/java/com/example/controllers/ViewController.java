package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.dtos.UserDto;
import com.example.grpc.UserDtoGrpc;
import com.example.grpc.ViewServiceGrpc;
import com.example.services.UserService;

import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ViewController extends ViewServiceGrpc.ViewServiceImplBase {
	
	private UserService userService;

	@Autowired
	public ViewController(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void view(com.example.grpc.ViewCommandGrpc commandGrpc,
        io.grpc.stub.StreamObserver<com.example.grpc.UserDtoGrpc> responseObserver) {

			UserDto userDto = userService.findById(commandGrpc.getId());
			UserDtoGrpc userDtoGrpc = UserDtoGrpc.newBuilder().setId(userDto.getId()).setName(userDto.getName()).build();
			responseObserver.onNext(userDtoGrpc);
            responseObserver.onCompleted();
      
    }

}