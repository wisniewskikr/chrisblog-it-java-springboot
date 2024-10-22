package com.example.exceptionhandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.exception.ReservationException;
import com.example.model.dto.ResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> infos = new HashMap<>();
        
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            infos.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(new ResponseDto(HttpStatus.BAD_REQUEST.value(), infos, null), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ReservationException.class)
    public ResponseEntity<ResponseDto> handleMessageException(ReservationException ex) {

        Map<String, String> infos = new HashMap<>();
        infos.put("info", ex.getMessage());
        return new ResponseEntity<>(new ResponseDto(HttpStatus.NOT_FOUND.value(), infos, null), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto> handleException(Exception ex) {

        Map<String, String> infos = new HashMap<>();
        infos.put("info", ex.getMessage());
        return new ResponseEntity<>(new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), infos, null), HttpStatus.INTERNAL_SERVER_ERROR);

    }

}