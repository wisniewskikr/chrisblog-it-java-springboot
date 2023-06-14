package com.example.controllers;

import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.jsons.HelloWorldBeJson;

import reactor.core.publisher.Mono;

@RestController
public class TmpController {

    private HttpGraphQlClient graphQlClient;

    public TmpController() {

        WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:9090/graphql")
            .build();

        graphQlClient = HttpGraphQlClient.builder(webClient).build();

    }

    @GetMapping("/tmp")
    public HelloWorldBeJson tmp() {

        String document = """
                query {
                    helloWorldBe {
                        message
                        portBe
                        uuidBe
                    }
                }
                """;

        Mono<HelloWorldBeJson> entity = graphQlClient.document(document)
                .retrieve("helloWorldBe")
                .toEntity(HelloWorldBeJson.class);

        return entity.block();

    }
    
}
