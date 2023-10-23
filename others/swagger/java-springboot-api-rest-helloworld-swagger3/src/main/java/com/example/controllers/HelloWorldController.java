package com.example.controllers;

import java.util.List;

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

import com.example.models.HelloWorldModel;
import com.example.models.InfoModel;
import com.example.services.HelloWorldService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/messages")
@Tag(name = "Messages", description = "Messages management APIs")
public class HelloWorldController {
	
	private HelloWorldService helloWorldService;

	@Autowired
	public HelloWorldController(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@Operation(
    	summary = "Retrieve a list of messages",
      	description = "Get a list of HelloWorldModel objects.")
	@GetMapping
	public ResponseEntity<List<HelloWorldModel>> list() {		
		List<HelloWorldModel> models = helloWorldService.findAll();
		return ResponseEntity.ok(models);
	}

	@Operation(
      	summary = "Retrieve a HelloWorldModel object by Id",
      	description = "Get a HelloWorldModel object by specifying its Id. The response is HelloWorldModel object with id and text.")
	@GetMapping(value="/{id}")
	public ResponseEntity<?> view(@Parameter(description = "Unique Id of Message", example = "1") @PathVariable Long id) {
		HelloWorldModel model = null;
		try {
			model = helloWorldService.findById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new InfoModel(e.getMessage()));
		}		
		return ResponseEntity.ok(model);
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody HelloWorldModel helloWorldModel) {
		String message = null;
		try {
			message = helloWorldService.save(helloWorldModel);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new InfoModel(e.getMessage()));
		}			
		return ResponseEntity.ok(new InfoModel(message));
	}

	@PutMapping
	public ResponseEntity<?> edit(@RequestBody HelloWorldModel helloWorldModel) {
		String message = null;
		try {
			message = helloWorldService.save(helloWorldModel);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new InfoModel(e.getMessage()));
		}			
		return ResponseEntity.ok(new InfoModel(message));
	}

	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		String message = null;
		try {
			message = helloWorldService.deleteById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new InfoModel(e.getMessage()));
		}		
		return ResponseEntity.ok(new InfoModel(message));
	}

}	