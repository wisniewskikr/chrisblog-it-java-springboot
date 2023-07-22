package com.example.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import com.example.dtos.HelloWorldDto;

public class HelloWorldControllerUT {

    @Test
    public void should_return_hello_world() throws Exception {
        
        //given
        HelloWorldController controller = new HelloWorldController();
        
        //when
        ResponseEntity<HelloWorldDto> result = controller.helloWorld();

        //then
        assertEquals("Hello World!", result.getBody().getMessage());

    }
    
}
