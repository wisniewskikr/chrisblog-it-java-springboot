package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.example.service.PostService;

@Configuration
public class HttpInterfaceConfig {

    	@Bean
	PostService postService() {
		RestClient client = RestClient.create("https://jsonplaceholder.typicode.com");
	    HttpServiceProxyFactory factory = HttpServiceProxyFactory
				.builderFor(RestClientAdapter.create(client))
				.build();
	    return factory.createClient(PostService.class);
	}
    
}
