package com.example.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import com.example.dto.HelloWorldDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HelloWorldService {

    @Qualifier("restClientPublic")
    private final RestClient restClientPublic;
    
    @Qualifier("restClientSecured")
    private final RestClient restClientSecured;

    public HelloWorldDto getHelloWorldPublic() {

        return restClientPublic.get()
                .uri("/demo/public")
                .retrieve()
                .body(HelloWorldDto.class);

    }

    public HelloWorldDto getHelloWorldSecured() {

        return restClientSecured.get()
                .uri("/demo/secured")
                .retrieve()
                .body(HelloWorldDto.class);

    }

}