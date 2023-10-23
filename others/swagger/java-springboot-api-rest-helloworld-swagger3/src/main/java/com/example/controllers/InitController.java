package com.example.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.InfoModel;

import io.swagger.v3.oas.annotations.Hidden;

@RestController
@Hidden
public class InitController {

    @GetMapping(value = "/")
	public ResponseEntity<?> init() {		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new InfoModel("Please use following path for API message: /api/v1/message"));
	}
    
}
