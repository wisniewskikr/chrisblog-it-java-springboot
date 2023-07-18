package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dtos.UserDto;
import com.example.services.UserService;

import net.devh.boot.grpc.server.service.GrpcService;

import com.example.grpc.CreateServiceGrpc;
import com.example.grpc.UserDtoGrpc;

@GrpcService
public class CreaterController extends CreateServiceGrpc.CreateServiceImplBase {
	
	private UserService userService;
	
	@Autowired
	public CreaterController(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void create(com.example.grpc.CreateCommandGrpc command,
        io.grpc.stub.StreamObserver<com.example.grpc.UserDtoGrpc> responseObserver) {

			UserDto userDto = userService.save(new UserDto(command.getName()));
			UserDtoGrpc userDtoGrpc = UserDtoGrpc.newBuilder().setId(userDto.getId()).setName(userDto.getName()).build();
			responseObserver.onNext(userDtoGrpc);
            responseObserver.onCompleted();
      
    }

}