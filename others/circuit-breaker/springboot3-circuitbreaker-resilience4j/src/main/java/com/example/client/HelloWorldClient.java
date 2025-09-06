package com.example.client;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface HelloWorldClient {

    @GetExchange
    String helloWorld();

}
