package com.example.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.dtos.UserDto;
import com.example.services.UserService;

import net.devh.boot.grpc.server.service.GrpcService;

import com.example.grpc.ListServiceGrpc;
import com.example.grpc.UserDtoGrpc;

@GrpcService
public class ListController extends ListServiceGrpc.ListServiceImplBase {
	
	private UserService userService;

	@Autowired
	public ListController(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void list(com.example.grpc.ListCommandGrpc request,
        io.grpc.stub.StreamObserver<com.example.grpc.UserDtoGrpc> responseObserver) {

			List<UserDto> list = userService.findAll();
			list.stream().forEach(user -> responseObserver.onNext(UserDtoGrpc.newBuilder().setId(user.getId()).setName(user.getName()).build()));
            responseObserver.onCompleted();
      
    }

}