package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dtos.HelloWorldDto;
import com.example.records.HelloWorldRecord;
import com.example.repositories.HelloWorldRepository;

@Service
public class HelloWorldService {
	
	private HelloWorldRepository helloWorldRepository;

	@Autowired
	public HelloWorldService(HelloWorldRepository helloWorldRepository) {
		this.helloWorldRepository = helloWorldRepository;
	}
	
	public HelloWorldDto saveText(Long id, String text) {
		HelloWorldRecord record = new HelloWorldRecord(id, text);
		helloWorldRepository.save(record);
		return new HelloWorldDto(record.id(), record.text());
	}
	
	public String readText(Long id) {
		return helloWorldRepository.findById(id).get().text();
	}

}
