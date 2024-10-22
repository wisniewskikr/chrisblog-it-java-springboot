package com.example.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

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
    
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ReservationDto save(ReservationDto reservation) {

        if (reservation == null) 
            throw new IllegalArgumentException("Argument 'reservation' in method save() cannot be null");

        logger.info("Method save() was called.");

        if (!isRoomAvailable(null, reservation.getRoomName(), reservation.getStartTime(), reservation.getEndTime())) {
            throw new ReservationException("Room is not available for the selected time.");
        }

        ReservationEntity entity = new ReservationEntity(reservation.getRoomName(), reservation.getReservedBy(), reservation.getStartTime(), reservation.getEndTime());
        entity = repository.save(entity);
        return new ReservationDto(entity.getId(), entity.getRoomName(), entity.getReservedBy(), entity.getStartTime(), entity.getEndTime());
        
    }

    public ReservationDto findById(Long id) throws ReservationException {

        if (id == null)
            throw new IllegalArgumentException("Argument 'id' in method findById() cannot be null");

        logger.info("Method findById() was called for id {}.", id);

        ReservationEntity entity = repository.findById(id).orElseThrow(() -> new ReservationException("There is no Reservation with id: " + id));
        return new ReservationDto(entity.getId(), entity.getRoomName(), entity.getReservedBy(), entity.getStartTime(), entity.getEndTime());

    }

    public List<ReservationDto> findAll() {

        logger.info("Method findAll() was called.");

        List<ReservationDto> dtos = new ArrayList<>();

        List<ReservationEntity> entities = repository.findAll();
        for (ReservationEntity entity : entities) {
            dtos.add(new ReservationDto(entity.getId(), entity.getRoomName(), entity.getReservedBy(), entity.getStartTime(), entity.getEndTime()));
        }
        
        return dtos;

    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ReservationDto update(ReservationDto reservation) {

        if (reservation == null) 
            throw new IllegalArgumentException("Argument 'reservation' in method update() cannot be null");

        logger.info("Method update() was called for id {}.", reservation.getId());

        if (!isRoomAvailable(reservation.getId(), reservation.getRoomName(), reservation.getStartTime(), reservation.getEndTime())) {
            throw new ReservationException("Room is not available for the selected time.");
        }

        ReservationEntity entity = new ReservationEntity(reservation.getId(), reservation.getRoomName(), reservation.getReservedBy(), reservation.getStartTime(), reservation.getEndTime());
        entity = repository.save(entity);
        return new ReservationDto(entity.getId(), entity.getRoomName(), entity.getReservedBy(), entity.getStartTime(), entity.getEndTime());
        
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(Long id) throws ReservationException { 
        
        if (id == null)
            throw new IllegalArgumentException("Argument 'id' in method delete() cannot be null");
        
        logger.info("Method delete() was called for id {}.", id);
        
        ReservationEntity entity = repository.findById(id).orElseThrow(() -> new ReservationException("There is no Reservation with id: " + id));
        repository.delete(entity);
        
    }

    public boolean isRoomAvailable(Long id, String roomName, LocalDateTime startTime, LocalDateTime endTime) {

        List<ReservationEntity> overlappingReservations = null;

        if (id == null) {
            overlappingReservations = repository
                .findByRoomNameAndStartTimeLessThanAndEndTimeGreaterThan(
                        roomName, endTime, startTime);
        } else {
            overlappingReservations = repository
                .findByIdNotAndRoomNameAndStartTimeLessThanAndEndTimeGreaterThan(
                        id, roomName, endTime, startTime);
        }
        

        return overlappingReservations.isEmpty();
    }

}