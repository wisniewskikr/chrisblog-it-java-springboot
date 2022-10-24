package com.example.app.controllers;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.requests.GreetingRequest;
import com.example.app.responses.GreetingResponse;

@RestController
public class GreetingController {

	@GetMapping(value="/greeting", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GreetingResponse> greetingGet(@PathParam("name")String name) {
		
		GreetingResponse response = new GreetingResponse(HttpStatus.OK, String.format("GET: Hello World: %s!", name));
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	@PostMapping(value="/greeting", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GreetingResponse> greetingPost(@RequestBody GreetingRequest greetingRequest) {
		
		GreetingResponse response = new GreetingResponse(HttpStatus.OK, String.format("POST: Hello World: %s!", greetingRequest.getName()));
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
}