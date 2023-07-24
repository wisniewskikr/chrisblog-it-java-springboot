package com.example.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloWorldControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_hello_world() throws Exception {
        
        mockMvc
            .perform(MockMvcRequestBuilders
                .get("/")
            )
            .andExpect(MockMvcResultMatchers
                .content()
                .string("{\"message\":\"Hello World!\"}")
            );

    }
    
}
