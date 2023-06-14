package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.jsons.HelloWorldBeJson;
import com.fasterxml.jackson.databind.ObjectMapper;

import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;

@RestController
public class Tmp2Controller {

    private final GraphQLWebClient graphQLWebClient;

    public Tmp2Controller() {

        ObjectMapper objectMapper = new ObjectMapper();
        
        WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:9090/graphql")
            .build();

        graphQLWebClient = GraphQLWebClient.newInstance(webClient, objectMapper);

    }

    @GetMapping("/tmp2")
    public HelloWorldBeJson tmp2() {

        GraphQLRequest request = GraphQLRequest.builder().resource("graphql/getHelloWorldBe.graphql").build();
        GraphQLResponse response = graphQLWebClient.post(request).block();
        return response.get("helloWorldBe", HelloWorldBeJson.class);

    }
    
}
