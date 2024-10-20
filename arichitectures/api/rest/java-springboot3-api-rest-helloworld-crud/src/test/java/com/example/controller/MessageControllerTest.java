package com.example.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.exception.MessageException;
import com.example.model.dto.MessageDto;
import com.example.service.MessageService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
public class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageService messageService;

    private ObjectMapper objectMapper = new ObjectMapper();

    private MessageDto message1;
    private MessageDto message2;

    @BeforeEach
    void setUp() {
        message1 = new MessageDto(1L, "Hello World 1!");
        message2 = new MessageDto(2L, "Hello World 2!");
    }

    @Test
    void testCreate_Ok() throws Exception {

        when(messageService.save(any(MessageDto.class))).thenReturn(message1);

        String messageJson = objectMapper.writeValueAsString(message1);

        mockMvc.perform(post("/api/v1/messages")
                .contentType(MediaType.APPLICATION_JSON)
                .content(messageJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.infos.info").value("Message with id 1 was created"))
                .andExpect(jsonPath("$.messages[0].id").value(1))
                .andExpect(jsonPath("$.messages[0].text").value("Hello World 1!"));

    }

    @Test
    void testDelete_Ok() throws Exception {

        mockMvc.perform(delete("/api/v1/messages/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusCode").value(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.infos.info").value("Message with id 1 was deleted"))
                .andExpect(jsonPath("$.messages").isEmpty());

    }

    @Test
    void testDelete_NotExists() throws Exception {

        doThrow(new MessageException("There is no Message with id: 1")).when(messageService).delete(1L);

        mockMvc.perform(delete("/api/v1/messages/1"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.statusCode").value(HttpStatus.NOT_FOUND.value()))
                .andExpect(jsonPath("$.infos.info").value("There is no Message with id: 1"))
                .andExpect(jsonPath("$.messages").isEmpty());

    }

    @Test
    void testRead_Ok() throws Exception {

        when(messageService.findById(1L)).thenReturn(message1);

        mockMvc.perform(get("/api/v1/messages/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusCode").value(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.infos.info").value("Message with id 1 was received"))
                .andExpect(jsonPath("$.messages[0].id").value(1))
                .andExpect(jsonPath("$.messages[0].text").value("Hello World 1!"));

    }

    @Test
    void testRead_NotExists() throws Exception {

        when(messageService.findById(1L)).thenThrow(new MessageException("There is no Message with id: 1"));

        mockMvc.perform(get("/api/v1/messages/1"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.statusCode").value(HttpStatus.NOT_FOUND.value()))
                .andExpect(jsonPath("$.infos.info").value("There is no Message with id: 1"))
                .andExpect(jsonPath("$.messages").isEmpty());

    }

    @Test
    void testReadAll_Ok() throws Exception {

        when(messageService.findAll()).thenReturn(Arrays.asList(message1, message2));

        mockMvc.perform(get("/api/v1/messages"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusCode").value(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.infos.info").value("Messages were received"))
                .andExpect(jsonPath("$.messages[0].id").value(1))
                .andExpect(jsonPath("$.messages[0].text").value("Hello World 1!"))
                .andExpect(jsonPath("$.messages[1].id").value(2))
                .andExpect(jsonPath("$.messages[1].text").value("Hello World 2!"));

    }

    @Test
    void testReadAll_Empty() throws Exception {

        when(messageService.findAll()).thenReturn(new ArrayList<MessageDto>());

        mockMvc.perform(get("/api/v1/messages"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusCode").value(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.infos.info").value("Messages were received"))
                .andExpect(jsonPath("$.messages").isEmpty());

    }

    @Test
    void testUpdate_Ok() throws Exception {

        when(messageService.findById(1L)).thenReturn(message1);
        when(messageService.update(any(MessageDto.class))).thenReturn(message2);

        String messageJson = objectMapper.writeValueAsString(message1);

        mockMvc.perform(put("/api/v1/messages/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(messageJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusCode").value(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.infos.info").value("Message with id 1 was updated"))
                .andExpect(jsonPath("$.messages[0].id").value(2))
                .andExpect(jsonPath("$.messages[0].text").value("Hello World 2!"));

    }

}
