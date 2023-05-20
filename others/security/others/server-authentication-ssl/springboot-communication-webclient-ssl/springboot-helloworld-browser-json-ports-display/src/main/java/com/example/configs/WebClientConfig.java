package com.example.configs;

import javax.net.ssl.SSLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.handler.ssl.SslContext;
import nl.altindag.ssl.SSLFactory;
import nl.altindag.ssl.util.NettySslUtils;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebClientConfig {
	
	@Value(value = "${truststore.name}")
	private String truststoreName;
	
	@Value(value = "${truststore.password}")
	private String truststorePassword;
	
	@Bean
    WebClient webClient() throws SSLException {
		
		SSLFactory sslFactory = SSLFactory.builder()
                .withTrustMaterial(truststoreName, truststorePassword.toCharArray())
                .build();

        SslContext sslContext = NettySslUtils.forClient(sslFactory).build();
			                
		HttpClient httpClient = HttpClient.create().secure(t -> t.sslContext(sslContext));

		return WebClient
				.builder()
			    .clientConnector(new ReactorClientHttpConnector(httpClient)).build();
		
	}

}
