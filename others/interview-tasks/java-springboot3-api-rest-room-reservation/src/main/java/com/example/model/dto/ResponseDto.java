package com.example.model.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class ResponseDto {
    
    private int statusCode;
    private Map<String, String> infos = new HashMap<>();
    private List<ReservationDto> reservations = new ArrayList<>();

    public ResponseDto(int statusCode, Map<String, String> infos, List<ReservationDto> reservations) {
        this.statusCode = statusCode;
        this.infos = infos;
        this.reservations = reservations;
    }
    
    public int getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    public Map<String, String> getInfos() {
        return infos;
    }
    public void setInfos(Map<String, String> infos) {
        this.infos = infos;
    }
    public List<ReservationDto> getReservations() {
        return reservations;
    }
    public void setReservations(List<ReservationDto> reservations) {
        this.reservations = reservations;
    }    

}