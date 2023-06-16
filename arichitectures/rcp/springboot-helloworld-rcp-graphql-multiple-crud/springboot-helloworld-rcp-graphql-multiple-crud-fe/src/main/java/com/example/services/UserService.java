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

        if (userDto.getId() == null) {
            GraphQLRequest request = GraphQLRequest.builder().resource("graphql/create.graphql").variables(Map.of("name", userDto.getName())).build();
            GraphQLResponse response = graphQLWebClient.post(request).block();
            return response.get("create", UserDto.class);
        } else {
            GraphQLRequest request = GraphQLRequest.builder().resource("graphql/edit.graphql").variables(Map.of("id", userDto.getId(), "name", userDto.getName())).build();
            GraphQLResponse response = graphQLWebClient.post(request).block();
            return response.get("edit", UserDto.class);
        }

    }

    public void deleteById(Long id) {
        GraphQLRequest request = GraphQLRequest.builder().resource("graphql/delete.graphql").variables(Map.of("id", id)).build();
        GraphQLResponse response = graphQLWebClient.post(request).block();
        response.get("delete", null);
    }
    
    public UserDto findById(Long id) {
        GraphQLRequest request = GraphQLRequest.builder().resource("graphql/view.graphql").variables(Map.of("id", id)).build();
        GraphQLResponse response = graphQLWebClient.post(request).block();
        return response.get("view", UserDto.class);
    }

    public List<UserDto> findAll() {
        GraphQLRequest request = GraphQLRequest.builder().resource("graphql/list.graphql").build();
        GraphQLResponse response = graphQLWebClient.post(request).block();
        return response.getList("list", UserDto.class);
    }
    
}