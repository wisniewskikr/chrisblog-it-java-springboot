package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.MessageException;
import com.example.model.dto.MessageDto;
import com.example.model.entity.MessageEntity;
import com.example.repository.MessageRepository;

@Service
public class MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);
    
    private MessageRepository repository;

    @Autowired
    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }
    
    public MessageDto save(MessageDto message) {

        if (message == null) 
            throw new IllegalArgumentException("Argument 'message' in method save() cannot be null");

        logger.info("Method save() was called.");

        MessageEntity entity = new MessageEntity(message.getText());
        entity = repository.save(entity);
        return new MessageDto(entity.getId(), entity.getText());
        
    }

    public MessageDto findById(Long id) throws MessageException {

        if (id == null)
            throw new IllegalArgumentException("Argument 'id' in method findById() cannot be null");

        logger.info("Method findById() was called for id {}.", id);

        MessageEntity entity = repository.findById(id).orElseThrow(() -> new MessageException("There is no Message with id: " + id));
        return new MessageDto(entity.getId(), entity.getText());

    }

    public List<MessageDto> findAll() {

        logger.info("Method findAll() was called.");

        List<MessageDto> dtos = new ArrayList<>();

        List<MessageEntity> entities = repository.findAll();
        for (MessageEntity entity : entities) {
            dtos.add(new MessageDto(entity.getId(), entity.getText()));
        }
        
        return dtos;

    }

    public MessageDto update(MessageDto message) {

        if (message == null) 
            throw new IllegalArgumentException("Argument 'message' in method update() cannot be null");

        logger.info("Method update() was called for id {}.", message.getId());

        MessageEntity entity = new MessageEntity(message.getId(), message.getText());
        entity = repository.save(entity);
        return new MessageDto(entity.getId(), entity.getText());
        
    }

    public void delete(Long id) throws MessageException { 
        
        if (id == null)
            throw new IllegalArgumentException("Argument 'id' in method delete() cannot be null");
        
        logger.info("Method delete() was called for id {}.", id);
        
        MessageEntity entity = repository.findById(id).orElseThrow(() -> new MessageException("There is no Message with id: " + id));
        repository.delete(entity);
        
    }

}