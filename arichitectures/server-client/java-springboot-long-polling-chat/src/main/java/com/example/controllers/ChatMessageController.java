package com.example.controllers;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.ChatMessageModel;
import com.example.models.ReadRequestModel;
import com.example.models.SendResponseModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ChatMessageController {

    @GetMapping("/")
    public void index(HttpServletResponse response) throws IOException {
        response.sendRedirect("index.html");
    }

    @PostMapping("/send")
    public ResponseEntity<SendResponseModel> send(@RequestBody ChatMessageModel model) {

        long lastId = getLastId();        
        long currentId = getCurrentId(lastId);        
        saveMessage(currentId, model);

        return ResponseEntity.ok(new SendResponseModel(currentId));

    }

    @PostMapping("/read")
    public ResponseEntity<ChatMessageModel> read(@RequestBody ReadRequestModel model) throws InterruptedException {        

        ChatMessageModel chatModel;
        
        waitForMessage(model);

        long id = model.getId() + 1;
        chatModel = readMessage(id);
        return ResponseEntity.ok(chatModel);

    } 
    
    private void waitForMessage(ReadRequestModel model) throws InterruptedException {

        long lastId = getLastId();

        if (lastId <= model.getId()) {
            Thread.sleep(3000);
            waitForMessage(model);
        }

    }

    private long getLastId() {

        long lastId;

        String lastIdString = System.getProperty("lastId");
        if (lastIdString == null) {
            lastId = 0;
        } else {
            lastId = Long.valueOf(lastIdString);
        }

        return lastId;

    }

    private long getCurrentId(long lastId) {

        lastId++;
        long currentId = lastId;
        return currentId;

    }

    private void saveMessage(long currentId, ChatMessageModel model) {

        model.setId(currentId);
        Gson gson = new GsonBuilder().create();
        System.setProperty("lastId", String.valueOf(currentId));
        System.setProperty(String.valueOf(currentId), gson.toJson(model));

    }

    private ChatMessageModel readMessage(long id) {

        String modelString = System.getProperty(String.valueOf(id));
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(modelString, ChatMessageModel.class);

    }
    
}
