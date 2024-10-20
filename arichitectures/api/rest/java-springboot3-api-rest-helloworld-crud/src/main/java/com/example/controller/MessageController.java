package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<MessageDto> create(@Valid @RequestBody MessageDto message) {        
        message = service.save(message);
        return ResponseEntity.ok().body(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDto> read(@PathVariable("id") Long id) {
            MessageDto message = service.findById(id);
            return ResponseEntity.ok().body(message);
    }

    @GetMapping()
    public ResponseEntity<List<MessageDto>> readAll() {
            List<MessageDto> messages = service.findAll();
            return ResponseEntity.ok().body(messages);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDto> update(@PathVariable("id") Long id, @Valid @RequestBody MessageDto messageNew) { 
        MessageDto message = service.findById(id); 
        message.setText(messageNew.getText());      
        message = service.update(message);
        return ResponseEntity.ok().body(message);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id") Long id) {
            service.delete(id);
            Map<String, String> messages = new HashMap<>();
            messages.put("message", String.format("Message with id %d was successfully deleted.", id));
            return ResponseEntity.ok().body(messages);
    }

}