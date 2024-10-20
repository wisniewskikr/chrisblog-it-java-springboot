package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.MessageException;
import com.example.model.dto.MessageDto;
import com.example.model.entity.MessageEntity;
import com.example.repository.MessageRepository;

@Service
public class MessageService {
    
    private MessageRepository repository;

    @Autowired
    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }
    
    public MessageDto save(MessageDto message) {

        MessageEntity entity = new MessageEntity(message.getText());
        entity = repository.save(entity);
        return new MessageDto(entity.getId(), entity.getText());
        
    }

    public MessageDto findById(Long id) throws MessageException {
        MessageEntity entity = repository.findById(id).orElseThrow(() -> new MessageException("There is no Message with id: " + id));
        return new MessageDto(entity.getId(), entity.getText());
    }

}