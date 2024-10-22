package com.example.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "RESERVATION")
public class ReservationEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomName;    
    private String reservedBy;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public ReservationEntity() {}    

    public ReservationEntity(Long id, String roomName, String reservedBy, LocalDateTime startTime,
            LocalDateTime endTime) {
        this.id = id;
        this.roomName = roomName;
        this.reservedBy = reservedBy;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public ReservationEntity(String roomName, String reservedBy, LocalDateTime startTime, LocalDateTime endTime) {
        this.roomName = roomName;
        this.reservedBy = reservedBy;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getRoomName() {
        return roomName;
    }
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    public String getReservedBy() {
        return reservedBy;
    }
    public void setReservedBy(String reservedBy) {
        this.reservedBy = reservedBy;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }    

}