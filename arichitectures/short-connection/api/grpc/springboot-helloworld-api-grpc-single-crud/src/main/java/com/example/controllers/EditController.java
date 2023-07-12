package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.dtos.UserDto;
import com.example.services.UserService;

import net.devh.boot.grpc.server.service.GrpcService;

import com.example.grpc.EditServiceGrpc;
import com.example.grpc.UserDtoGrpc;

@GrpcService
public class EditController extends EditServiceGrpc.EditServiceImplBase {
	
	private UserService userService;

	@Autowired
	public EditController(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void edit(com.example.grpc.EditCommandGrpc commandGrpc,
        io.grpc.stub.StreamObserver<com.example.grpc.UserDtoGrpc> responseObserver) {
      
			UserDto userDto = userService.save(new UserDto(commandGrpc.getId(), commandGrpc.getName()));
			UserDtoGrpc userDtoGrpc = UserDtoGrpc.newBuilder().setId(userDto.getId()).setName(userDto.getName()).build();
			responseObserver.onNext(userDtoGrpc);
            responseObserver.onCompleted();

    }

}