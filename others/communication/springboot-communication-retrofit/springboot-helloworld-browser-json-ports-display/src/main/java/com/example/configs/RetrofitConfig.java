package com.example.configs;

import okhttp3.OkHttpClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.retrofit.services.TextService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {
	
	@Value("${text.url}")
	private String textUrl;
	
	private final OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
	
	@Bean
    public TextService buildServiceBooksEndpoint() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(textUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();
        return retrofit.create(TextService.class);
        
    }

}
