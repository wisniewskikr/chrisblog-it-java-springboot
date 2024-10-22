package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.ReservationException;
import com.example.model.dto.ReservationDto;
import com.example.model.entity.ReservationEntity;
import com.example.repository.ReservationRepository;

@Service
public class ReservationService {

    private static final Logger logger = LoggerFactory.getLogger(ReservationService.class);
    
    private ReservationRepository repository;

    @Autowired
    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }
    
    public ReservationDto save(ReservationDto message) {

        if (message == null) 
            throw new IllegalArgumentException("Argument 'message' in method save() cannot be null");

        logger.info("Method save() was called.");

        ReservationEntity entity = new ReservationEntity(message.getText());
        entity = repository.save(entity);
        return new ReservationDto(entity.getId(), entity.getText());
        
    }

    public ReservationDto findById(Long id) throws ReservationException {

        if (id == null)
            throw new IllegalArgumentException("Argument 'id' in method findById() cannot be null");

        logger.info("Method findById() was called for id {}.", id);

        ReservationEntity entity = repository.findById(id).orElseThrow(() -> new ReservationException("There is no Message with id: " + id));
        return new ReservationDto(entity.getId(), entity.getText());

    }

    public List<ReservationDto> findAll() {

        logger.info("Method findAll() was called.");

        List<ReservationDto> dtos = new ArrayList<>();

        List<ReservationEntity> entities = repository.findAll();
        for (ReservationEntity entity : entities) {
            dtos.add(new ReservationDto(entity.getId(), entity.getText()));
        }
        
        return dtos;

    }

    public ReservationDto update(ReservationDto message) {

        if (message == null) 
            throw new IllegalArgumentException("Argument 'message' in method update() cannot be null");

        logger.info("Method update() was called for id {}.", message.getId());

        ReservationEntity entity = new ReservationEntity(message.getId(), message.getText());
        entity = repository.save(entity);
        return new ReservationDto(entity.getId(), entity.getText());
        
    }

    public void delete(Long id) throws ReservationException { 
        
        if (id == null)
            throw new IllegalArgumentException("Argument 'id' in method delete() cannot be null");
        
        logger.info("Method delete() was called for id {}.", id);
        
        ReservationEntity entity = repository.findById(id).orElseThrow(() -> new ReservationException("There is no Message with id: " + id));
        repository.delete(entity);
        
    }

}