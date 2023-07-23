package com.example.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.ResponseEntity;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.services.MessageService;
import com.example.dtos.HelloWorldDto;

@ExtendWith(MockitoExtension.class)
public class HelloWorldControllerIT {

    @Spy
    private MessageService messageService;

    @Test
    public void should_return_hello_world() throws Exception {
        
        //given
        Mockito.when(messageService.getMessage()).thenReturn("Hello World!");
        HelloWorldController controller = new HelloWorldController(messageService);
        
        //when
        ResponseEntity<HelloWorldDto> result = controller.helloWorld();

        //then
        assertEquals("Hello World!", result.getBody().getMessage());

    }
    
}
