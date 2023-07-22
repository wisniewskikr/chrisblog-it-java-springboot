package com.example.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.mockito.Mockito;
import com.example.services.MessageService;
import com.example.dtos.HelloWorldDto;


public class HelloWorldControllerUT {

    @Test
    public void should_return_hello_world() throws Exception {
        
        //given
        MessageService messageService = Mockito.mock(MessageService.class);
        Mockito.when(messageService.getMessage()).thenReturn("Hello World!");
        HelloWorldController controller = new HelloWorldController(messageService);
        
        //when
        ResponseEntity<HelloWorldDto> result = controller.helloWorld();

        //then
        assertEquals("Hello World!", result.getBody().getMessage());

    }
    
}
