package com.example.config;

import com.example.client.HelloWorldClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientConfig {

    @Value("${api.url}")
    private String apiUrl;

    @Bean
    public RestClient.Builder getRestClient() {
        return RestClient.builder();
    }

    @Bean
    public HelloWorldClient helloWorldClient() {

        RestClient restClient = getRestClient()
                .baseUrl(apiUrl)
                .build();
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory
                = HttpServiceProxyFactory.builderFor(adapter).build();
        return factory.createClient(HelloWorldClient.class);

    }

}