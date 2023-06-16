package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dtos.UserDto;

import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;

@Service
public class UserService {

    private GraphQLWebClient graphQLWebClient;

    public UserService(GraphQLWebClient graphQLWebClient) {
        this.graphQLWebClient = graphQLWebClient;
    }

    public UserDto save(UserDto userDto) {
        return null
    }

    public void deleteById(Long id) {
    }
    
    public UserDto findById(Long id) {
        return null;
    }

    public List<UserDto> findAll() {
        return null;
    }
    
}
