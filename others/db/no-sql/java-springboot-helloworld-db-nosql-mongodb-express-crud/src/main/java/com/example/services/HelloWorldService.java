package com.example.services;

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
	
	public String readText(String id) {
		return helloWorldRepository.findById(id).get().getText();
	}

}
