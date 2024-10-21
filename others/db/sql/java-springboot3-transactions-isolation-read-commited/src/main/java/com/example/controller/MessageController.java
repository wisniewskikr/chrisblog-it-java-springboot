package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.dto.MessageDto;
import com.example.model.dto.ResponseDto;
import com.example.service.MessageService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {
    
    private MessageService service;

    @Autowired
    public MessageController(MessageService service) {
        this.service = service;
    }
    
    @PostMapping
    public ResponseEntity<ResponseDto> create(@Valid @RequestBody MessageDto message) {        
        
        message = service.save(message);

        Map<String, String> infos = new HashMap<>();
        infos.put("info", String.format("Message with id %d was created", message.getId()));

        List<MessageDto> messages = new ArrayList<>();
        messages.add(message);

        return new ResponseEntity<>(new ResponseDto(HttpStatus.CREATED.value(), infos, messages), HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> read(@PathVariable("id") Long id) {

        MessageDto message = service.findById(id);
            
        Map<String, String> infos = new HashMap<>();
        infos.put("info", String.format("Message with id %d was received", id));

        List<MessageDto> messages = new ArrayList<>();
        messages.add(message);

        return new ResponseEntity<>(new ResponseDto(HttpStatus.OK.value(), infos, messages), HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<ResponseDto> readAll() {

        
        Map<String, String> infos = new HashMap<>();
        infos.put("info", "Messages were received");

        List<MessageDto> messages = service.findAll();

        return new ResponseEntity<>(new ResponseDto(HttpStatus.OK.value(), infos, messages), HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> update(@PathVariable("id") Long id, @Valid @RequestBody MessageDto messageNew) { 

        MessageDto message = service.findById(id); 
        message.setText(messageNew.getText());      
        message = service.update(message);

        Map<String, String> infos = new HashMap<>();
        infos.put("info", String.format("Message with id %d was updated", id));

        List<MessageDto> messages = new ArrayList<>();
        messages.add(message);

        return new ResponseEntity<>(new ResponseDto(HttpStatus.OK.value(), infos, messages), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable("id") Long id) {
            
        service.delete(id);

        Map<String, String> infos = new HashMap<>();
        infos.put("info", String.format("Message with id %d was deleted", id));

        return new ResponseEntity<>(new ResponseDto(HttpStatus.OK.value(), infos, null), HttpStatus.OK);
            
    }

}