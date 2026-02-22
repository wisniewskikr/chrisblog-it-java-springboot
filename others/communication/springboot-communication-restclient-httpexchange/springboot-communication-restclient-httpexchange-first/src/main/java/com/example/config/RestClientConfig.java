package com.example.config;

import com.example.client.SecondClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientConfig {

	@Value("${api.second.url}")
	private String apiSecondUrl;

	@Bean
	public RestClient.Builder restClientBuilder() {
		return RestClient.builder();
	}

	@Bean
	public SecondClient beClient(RestClient.Builder restClientBuilder) {

		RestClient restClient = restClientBuilder
				.baseUrl(apiSecondUrl)
				.build();

		var restClientAdapter = RestClientAdapter.create(restClient);
		var httpServiceProxyFactory =
				HttpServiceProxyFactory.builderFor(restClientAdapter).build();

		return httpServiceProxyFactory.createClient(SecondClient.class);
	}
}