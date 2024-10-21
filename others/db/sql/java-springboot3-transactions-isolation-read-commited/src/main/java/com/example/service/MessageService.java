package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.MessageException;
import com.example.model.dto.MessageDto;
import com.example.model.entity.MessageEntity;
import com.example.repository.MessageRepository;

import jakarta.annotation.PostConstruct;

@Service
public class MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);
    
    private MessageRepository repository;

    @Autowired
    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void setUp() {
        repository.save(new MessageEntity("Hello World"));
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

    public void updateWithError(MessageDto message) {

        MessageEntity entity = new MessageEntity(message.getId(), message.getText());
        entity = repository.save(entity);

        logger.info("Object Message with id {} was created", entity.getId());

        if (true)
            throw new MessageException("Example Exception");
        
    }

}