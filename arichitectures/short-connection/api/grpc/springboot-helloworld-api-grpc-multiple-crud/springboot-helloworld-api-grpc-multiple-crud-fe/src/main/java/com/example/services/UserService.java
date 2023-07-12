package com.example.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dtos.UserDto;
import com.example.grpc.CreateCommandGrpc;
import com.example.grpc.CreateServiceGrpc;
import com.example.grpc.DeleteCommandGrpc;
import com.example.grpc.DeleteResponseGrpc;
import com.example.grpc.DeleteServiceGrpc;
import com.example.grpc.EditCommandGrpc;
import com.example.grpc.EditServiceGrpc;
import com.example.grpc.ListCommandGrpc;
import com.example.grpc.ListServiceGrpc;
import com.example.grpc.UserDtoGrpc;
import com.example.grpc.ViewCommandGrpc;
import com.example.grpc.ViewServiceGrpc;

import io.grpc.ManagedChannel;

@Service
public class UserService {


    private ManagedChannel managedChannel;
    
    @Autowired
    public UserService(ManagedChannel managedChannel) {
        this.managedChannel = managedChannel;
    }

    public UserDto save(UserDto userDto) {

        if (userDto.getId() == null) {
            CreateServiceGrpc.CreateServiceBlockingStub blockingStub = CreateServiceGrpc.newBlockingStub(managedChannel);
            UserDtoGrpc userDtoGrpc = blockingStub.create(CreateCommandGrpc.newBuilder().setName(userDto.getName()).build());
            return new UserDto(userDtoGrpc.getId(), userDtoGrpc.getName());
        } else {
            EditServiceGrpc.EditServiceBlockingStub blockingStub = EditServiceGrpc.newBlockingStub(managedChannel);
            UserDtoGrpc userDtoGrpc = blockingStub.edit(EditCommandGrpc.newBuilder().setId(userDto.getId()).setName(userDto.getName()).build());
            return new UserDto(userDtoGrpc.getId(), userDtoGrpc.getName());
        }

    }

    public void deleteById(Long id) {
        DeleteServiceGrpc.DeleteServiceBlockingStub blockingStub = DeleteServiceGrpc.newBlockingStub(managedChannel);
        blockingStub.delete(DeleteCommandGrpc.newBuilder().setId(id).build());
    }
    
    public UserDto findById(Long id) {
        ViewServiceGrpc.ViewServiceBlockingStub blockingStub = ViewServiceGrpc.newBlockingStub(managedChannel);
        UserDtoGrpc userDtoGrpc = blockingStub.view(ViewCommandGrpc.newBuilder().setId(id).build());
        return new UserDto(userDtoGrpc.getId(), userDtoGrpc.getName());
    }

    public List<UserDto> findAll() {

        List<UserDto> list = new ArrayList<UserDto>();

        ListServiceGrpc.ListServiceBlockingStub blockingStub = ListServiceGrpc.newBlockingStub(managedChannel);
        Iterator<UserDtoGrpc> it = blockingStub.list(ListCommandGrpc.newBuilder().build());
        while(it.hasNext()) {
            UserDtoGrpc userDtoGrpc = it.next();
            list.add(new UserDto(userDtoGrpc.getId(), userDtoGrpc.getName()));
        }

        return list;

    }
    
}