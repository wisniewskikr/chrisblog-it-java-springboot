package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

	@Value("${api.second.url}")
	private String apiSecondUrl;
	
	@Bean
    RestClient restClient() {
		return RestClient.builder()
			.baseUrl(apiSecondUrl)
			.build();
	}

}