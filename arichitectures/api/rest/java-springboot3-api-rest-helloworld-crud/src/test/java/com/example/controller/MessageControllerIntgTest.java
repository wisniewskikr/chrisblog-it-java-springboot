package com.example.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
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
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    @Order(1)
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

        MessageEntity message = repository.save(new MessageEntity("Hello World"));

        given()
             .pathParam("id", message.getId())
        .when()
            .delete("/api/v1/messages/{id}")
        .then()
            .statusCode(HttpStatus.OK.value())
            .body("statusCode", equalTo(HttpStatus.OK.value()))
            .body("infos.info", equalTo(String.format("Message with id %d was deleted", message.getId())))
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

        MessageEntity message = repository.save(new MessageEntity("Hello World"));

        given()
            .pathParam("id", message.getId())
        .when()
            .get("/api/v1/messages/{id}")
        .then()
            .statusCode(HttpStatus.OK.value())
            .body("statusCode", equalTo(HttpStatus.OK.value()))
            .body("infos.info", equalTo(String.format("Message with id %d was received", message.getId())))
            .body("messages[0].id", equalTo(message.getId().intValue()))
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

    @Test
    void testReadAll_Ok() {

        MessageEntity message1 = repository.save(new MessageEntity("Hello World 1"));
        MessageEntity message2 =  repository.save(new MessageEntity("Hello World 2"));

        given()
        .when()
            .get("/api/v1/messages")
        .then()
            .statusCode(HttpStatus.OK.value())
            .body("statusCode", equalTo(HttpStatus.OK.value()))
            .body("infos.info", equalTo("Messages were received"))
            .body("messages[0].id", equalTo(message1.getId().intValue()))
            .body("messages[0].text", equalTo("Hello World 1"))
            .body("messages[1].id", equalTo(message2.getId().intValue()))
            .body("messages[1].text", equalTo("Hello World 2"));

    }

    @Test
    void testReadAll_Empty() {

        given()
        .when()
            .get("/api/v1/messages")
        .then()
            .statusCode(HttpStatus.OK.value())
            .body("statusCode", equalTo(HttpStatus.OK.value()))
            .body("infos.info", equalTo("Messages were received"))
            .body("messages", empty());

    }

    @Test
    void testUpdate_Ok() throws Exception {

        MessageEntity message = repository.save(new MessageEntity("Hello World 1"));

        String messageJson = objectMapper.writeValueAsString(new MessageDto(1L, "Hello World 2"));

        given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(messageJson)
            .pathParam("id", message.getId())
        .when()
            .put("/api/v1/messages/{id}")
        .then()
            .statusCode(HttpStatus.OK.value())
            .body("statusCode", equalTo(HttpStatus.OK.value()))
            .body("infos.info", equalTo(String.format("Message with id %d was updated", message.getId())))
            .body("messages[0].id", equalTo(message.getId().intValue()))
            .body("messages[0].text", equalTo("Hello World 2"));

    }

    @Test
    void testUpdate_NotExists() throws Exception {

        String messageJson = objectMapper.writeValueAsString(new MessageDto(1L, "Hello World 2"));

        given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(messageJson)
        .when()
            .put("/api/v1/messages/1")
        .then()
            .statusCode(HttpStatus.NOT_FOUND.value())
            .body("statusCode", equalTo(HttpStatus.NOT_FOUND.value()))
            .body("infos.info", equalTo("There is no Message with id: 1"))
            .body("messages", equalTo(null));

    }

}