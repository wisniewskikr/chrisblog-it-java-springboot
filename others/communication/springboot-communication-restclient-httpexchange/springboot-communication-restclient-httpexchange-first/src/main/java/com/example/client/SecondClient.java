package com.example.client;

import com.example.dto.HelloWorldDto;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface SecondClient {

    @GetExchange("/message")
    HelloWorldDto helloWorld();

}
