package com.example.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.model.dto.MessageDto;
import com.example.service.MessageService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageService messageService;

    private MessageDto message1;
    private MessageDto message2;

    @BeforeEach
    void setUp() {
        message1 = new MessageDto(1L, "Hello World 1!");
        message2 = new MessageDto(2L, "Hello World 2!");
    }

    // @Test
    // void testCreate() {

    // }

    // @Test
    // void testDelete() {

    // }

    @Test
    void testRead_Ok() throws Exception {

        when(messageService.findById(1L)).thenReturn(message1);

        mockMvc.perform(get("/api/v1/messages/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusCode").value(200))
                .andExpect(jsonPath("$.infos.info").value("Message with id 1 was received"))
                .andExpect(jsonPath("$.messages[0].id").value(1))
                .andExpect(jsonPath("$.messages[0].text").value("Hello World 1!"));

    }

    // @Test
    // void testReadAll() {

    // }

    // @Test
    // void testUpdate() {

    // }
}
