package com.example.exception;

public class ReservationException extends RuntimeException {
    public ReservationException(String message) {
        super(message);
    }
}