package com.example.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.documents.HelloWorldDoc;
import com.example.dtos.HelloWorldDto;
import com.example.repositories.HelloWorldRepository;

@Service
public class HelloWorldService {
	
	private HelloWorldRepository helloWorldRepository;

	@Autowired
	public HelloWorldService(HelloWorldRepository helloWorldRepository) {
		this.helloWorldRepository = helloWorldRepository;
	}
	
	public HelloWorldDto save(HelloWorldDto helloWorldDto) {
		HelloWorldDoc doc = new HelloWorldDoc(helloWorldDto);
		return new HelloWorldDto(helloWorldRepository.save(doc));
	}
	
	public HelloWorldDto read(String id) {
		Optional<HelloWorldDoc> optHelloWorldDoc = helloWorldRepository.findById(id);
		return new HelloWorldDto(optHelloWorldDoc.orElseThrow((() -> new RuntimeException("There is no document with id: " + id))));
	}

}
