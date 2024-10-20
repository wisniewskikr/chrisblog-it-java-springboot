package com.example.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;

import com.example.model.dto.MessageDto;
import com.example.repository.MessageRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MessageControllerIntgTest {

    @LocalServerPort
    private int port;

    @Autowired
    private MessageRepository repository;

    private ObjectMapper objectMapper = new ObjectMapper();
    private MessageDto message1;
    private MessageDto message2;
  

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
        message1 = new MessageDto(1L, "Hello World 1!");
        message2 = new MessageDto(2L, "Hello World 2!");
        repository.deleteAll();
    }

    @Test
    void testCreate_Ok() throws Exception {

        String messageJson = objectMapper.writeValueAsString(message1);

        given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(messageJson)
        .when()
            .post("/api/v1/messages")
        .then()
            .statusCode(201)
            .body("statusCode", equalTo(201));

    }

}