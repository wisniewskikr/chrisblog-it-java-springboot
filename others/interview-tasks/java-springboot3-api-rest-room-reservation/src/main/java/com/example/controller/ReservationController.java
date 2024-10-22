package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.example.model.dto.ReservationDto;
import com.example.model.dto.ResponseDto;
import com.example.service.ReservationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/reservations")
public class ReservationController {

    private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
    
    private ReservationService service;

    @Autowired
    public ReservationController(ReservationService service) {
        this.service = service;
    }
    
    @PostMapping
    public ResponseEntity<ResponseDto> create(@Valid @RequestBody ReservationDto reservation) { 
        
        logger.info("Method create() was called.");
        
        reservation = service.save(reservation);

        Map<String, String> infos = new HashMap<>();
        infos.put("info", String.format("Reservation with id %d was created", reservation.getId()));

        List<ReservationDto> reservations = new ArrayList<>();
        reservations.add(reservation);

        return new ResponseEntity<>(new ResponseDto(HttpStatus.CREATED.value(), infos, reservations), HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> read(@PathVariable("id") Long id) {

        logger.info("Method read() was called for id {}.", id);

        ReservationDto reservation = service.findById(id);
            
        Map<String, String> infos = new HashMap<>();
        infos.put("info", String.format("Reservation with id %d was received", id));

        List<ReservationDto> reservations = new ArrayList<>();
        reservations.add(reservation);

        return new ResponseEntity<>(new ResponseDto(HttpStatus.OK.value(), infos, reservations), HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<ResponseDto> readAll() {

        logger.info("Method readAll() was called for id.");
        
        Map<String, String> infos = new HashMap<>();
        infos.put("info", "Reservations were received");

        List<ReservationDto> reservations = service.findAll();

        return new ResponseEntity<>(new ResponseDto(HttpStatus.OK.value(), infos, reservations), HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> update(@PathVariable("id") Long id, @Valid @RequestBody ReservationDto reservationNew) {
        
        logger.info("Method update() was called for id {}.", id);

        ReservationDto reservation = service.findById(id); 
        reservation.setRoomName(reservationNew.getRoomName());
        reservation.setReservedBy(reservationNew.getReservedBy());
        reservation.setStartTime(reservationNew.getStartTime());
        reservation.setEndTime(reservationNew.getEndTime());     
        reservation = service.update(reservation);

        Map<String, String> infos = new HashMap<>();
        infos.put("info", String.format("Reservation with id %d was updated", id));

        List<ReservationDto> reservations = new ArrayList<>();
        reservations.add(reservation);

        return new ResponseEntity<>(new ResponseDto(HttpStatus.OK.value(), infos, reservations), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable("id") Long id) {

        logger.info("Method delete() was called for id {}.", id);
            
        service.delete(id);

        Map<String, String> infos = new HashMap<>();
        infos.put("info", String.format("Reservation with id %d was deleted", id));

        return new ResponseEntity<>(new ResponseDto(HttpStatus.OK.value(), infos, null), HttpStatus.OK);
            
    }

}