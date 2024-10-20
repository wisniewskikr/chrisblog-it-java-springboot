package com.example.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.example.model.dto.MessageDto;
import com.example.model.entity.MessageEntity;
import com.example.repository.MessageRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MessageControllerIntgTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @LocalServerPort
    private int port;

    @Autowired
    private MessageRepository repository;    
 
    @BeforeEach
    void setUp() {
        RestAssured.port = port;
        repository.deleteAll();
    }

    @Test
    void testCreate_Ok() throws Exception {

        String messageJson = objectMapper.writeValueAsString(new MessageDto(1L, "Hello World"));

        given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(messageJson)
        .when()
            .post("/api/v1/messages")
        .then()
            .statusCode(HttpStatus.CREATED.value())
            .body("statusCode", equalTo(HttpStatus.CREATED.value()))
            .body("infos.info", equalTo("Message with id 1 was created"))
            .body("messages[0].id", equalTo(1))
            .body("messages[0].text", equalTo("Hello World"));

    }

    @Test
    void testDelete_Ok() {

        repository.save(new MessageEntity("Hello World"));

        given()
        .when()
            .delete("/api/v1/messages/1")
        .then()
            .statusCode(HttpStatus.OK.value())
            .body("statusCode", equalTo(HttpStatus.OK.value()))
            .body("infos.info", equalTo("Message with id 1 was deleted"))
            .body("messages", equalTo(null));

    }

    @Test
    void testDelete_NotExists() {

        given()
        .when()
            .delete("/api/v1/messages/1")
        .then()
            .statusCode(HttpStatus.NOT_FOUND.value())
            .body("statusCode", equalTo(HttpStatus.NOT_FOUND.value()))
            .body("infos.info", equalTo("There is no Message with id: 1"))
            .body("messages", equalTo(null));

    }

    @Test
    void testRead_Ok() {

        repository.save(new MessageEntity("Hello World"));

        given()
        .when()
            .get("/api/v1/messages/1")
        .then()
            .statusCode(HttpStatus.OK.value())
            .body("statusCode", equalTo(HttpStatus.OK.value()))
            .body("infos.info", equalTo("Message with id 1 was received"))
            .body("messages[0].id", equalTo(1))
            .body("messages[0].text", equalTo("Hello World"));

    }

    @Test
    void testRead_NotExists() {

        given()
        .when()
            .get("/api/v1/messages/1")
        .then()
            .statusCode(HttpStatus.NOT_FOUND.value())
            .body("statusCode", equalTo(HttpStatus.NOT_FOUND.value()))
            .body("infos.info", equalTo("There is no Message with id: 1"))
            .body("messages", equalTo(null));

    }

    @Test
    void testRead_WrongUrl() {

        given()
        .when()
            .get("/api/v1/tmp")
        .then()
            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .body("statusCode", equalTo(HttpStatus.INTERNAL_SERVER_ERROR.value()))
            .body("infos.info", equalTo("No static resource api/v1/tmp."))
            .body("messages", equalTo(null));

    }

}