package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dtos.UserDto;
import com.example.entities.UserEntity;
import com.example.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto save(UserDto userDto) {
        UserEntity userEntity = userRepository.save(new UserEntity(userDto));
        return new UserDto(userEntity);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
    
    public UserDto findById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User doesn't exist"));
        return new UserDto(userEntity);
    }

    public List<UserDto> findAll() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(user -> new UserDto(user)).toList();
    }
    
}
