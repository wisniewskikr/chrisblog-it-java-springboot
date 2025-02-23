package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {
	
	@Bean
    RestClient restClient() {
		return RestClient.builder()
			.baseUrl("https://jsonplaceholder.typicode.com")
			.build();
	}

}