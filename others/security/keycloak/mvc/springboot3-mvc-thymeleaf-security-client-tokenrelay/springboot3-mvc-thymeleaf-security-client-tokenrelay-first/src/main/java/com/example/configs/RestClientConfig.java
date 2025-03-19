package com.example.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

import com.example.interceptor.JwtInterceptor;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class RestClientConfig {

	@Value("${api.second.url}")
	private String apiSecondUrl;

	private final JwtInterceptor jwtInterceptor;
	
	@Bean
    RestClient restClient() {
		return RestClient.builder()
			.baseUrl(apiSecondUrl)
			.requestInterceptor(jwtInterceptor)
			.build();
	}

}