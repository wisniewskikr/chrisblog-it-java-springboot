package com.example.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;

import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;

@Configuration
public class GraphQLWebClientConfig {

	@Value("${helloworld.be.url}")
	private String helloWorldBeUrl;
	
	@Bean
    GraphQLWebClient graphQLWebClient() {
		
		ObjectMapper objectMapper = new ObjectMapper();
        
        WebClient webClient = WebClient.builder()
            .baseUrl(helloWorldBeUrl)
            .build();

        return GraphQLWebClient.newInstance(webClient, objectMapper);

	}

}