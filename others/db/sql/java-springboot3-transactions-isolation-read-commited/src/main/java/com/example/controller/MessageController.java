package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.dto.MessageDto;
import com.example.model.dto.ResponseDto;
import com.example.service.MessageService;

@RestController
public class MessageController {
    
    private MessageService service;

    @Autowired
    public MessageController(MessageService service) {
        this.service = service;
    }    

    @GetMapping()
    public ResponseEntity<ResponseDto> readAll() {

        
        Map<String, String> infos = new HashMap<>();
        infos.put("info", "Messages were received");

        List<MessageDto> messages = service.findAll();

        return new ResponseEntity<>(new ResponseDto(HttpStatus.OK.value(), infos, messages), HttpStatus.OK);

    }

}