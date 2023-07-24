package com.example.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import com.example.dtos.HelloWorldDto;

@SpringBootTest
public class HelloWorldControllerIT {

    @Autowired
    private HelloWorldController controller;

    @Test
    public void should_return_hello_world() throws Exception {
        
        //given
        
        //when
        ResponseEntity<HelloWorldDto> result = controller.helloWorld();

        //then
        assertEquals("Hello World!", result.getBody().getMessage());

    }
    
}
