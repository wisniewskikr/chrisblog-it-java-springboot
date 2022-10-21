package com.example.configs;

import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebClientConfig {
	
	@Value("${keystore.path}")
	private String keyStorePath;
	
	@Value("${keystore.password}")
	private String keyStorePassword;
	
	@Bean
    WebClient webClient() {
		
		HttpClient httpClient = HttpClient.create().secure(t -> t.sslContext(createSSLContext()));

		return WebClient
				.builder()
			    .clientConnector(new ReactorClientHttpConnector(httpClient)).build();
		
	}
	
	private SslContext createSSLContext() {
		
		  try {
		      KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
		      keyStore.load(getClass().getClassLoader().getResourceAsStream(keyStorePath), keyStorePassword.toCharArray());

		      KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
		      keyManagerFactory.init(keyStore, keyStorePassword.toCharArray());

		      return SslContextBuilder.forClient()
		              .keyManager(keyManagerFactory)
		              .build();

		  } 
		  catch (Exception e) {
		      throw new RuntimeException("Error creating SSL context.");
		  }
		}

}
