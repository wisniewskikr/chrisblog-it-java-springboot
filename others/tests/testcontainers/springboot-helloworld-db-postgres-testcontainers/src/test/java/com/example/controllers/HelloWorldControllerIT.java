package com.example.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.base.BaseIT;

@AutoConfigureMockMvc
public class HelloWorldControllerIT extends BaseIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void helloWorld() throws Exception {
        mockMvc
            .perform(MockMvcRequestBuilders
                .get("/")
            )
            .andExpect(MockMvcResultMatchers
                .content()
                .string("Hello World!")
            );
    }
    
}
