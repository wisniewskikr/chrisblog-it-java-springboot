package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.dto.MessageDto;
import com.example.service.MessageService;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {
    
    private MessageService service;

    @Autowired
    public MessageController(MessageService service) {
        this.service = service;
    }
    
    @PostMapping
    public ResponseEntity<MessageDto> create(@RequestBody MessageDto message) {
        message = service.save(message);
        return ResponseEntity.ok().body(message);
    }

}