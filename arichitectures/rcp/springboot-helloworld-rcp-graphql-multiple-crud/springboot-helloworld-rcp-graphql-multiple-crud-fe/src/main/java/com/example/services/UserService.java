package com.example.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.dtos.UserDto;

import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;

@Service
public class UserService {

    private GraphQLWebClient graphQLWebClient;

    public UserService(GraphQLWebClient graphQLWebClient) {
        this.graphQLWebClient = graphQLWebClient;
    }

    public UserDto save(UserDto userDto) {
        GraphQLRequest request = GraphQLRequest.builder().resource("graphql/create.graphql").variables(Map.of("name", userDto.getName())).build();
        GraphQLResponse response = graphQLWebClient.post(request).block();
        return response.get("create", UserDto.class);
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
