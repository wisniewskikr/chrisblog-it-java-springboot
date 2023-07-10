package com.example.controllers;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.ChatMessageModel;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ChatMessageController {

    @GetMapping("/")
    public void index(HttpServletResponse response) throws IOException {
        response.sendRedirect("index.html");
    }

    @PostMapping("/send")
    public ResponseEntity<String> send(@RequestBody ChatMessageModel model) {

        System.out.println("send()");
        return ResponseEntity.ok("Message was sent.");

    }
    
}
