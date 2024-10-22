package com.example.model.dto;

import java.time.LocalDateTime;

public class ReservationDto {
    
    private Long id;
    private String roomName;    
    private String reservedBy;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public ReservationDto(Long id, String roomName, String reservedBy, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
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