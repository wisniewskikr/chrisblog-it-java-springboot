package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.HelloEntity;
import com.example.repositories.HelloRepository;

@Service
public class HelloService {
	
	private static final Long ENTITY_ID = Long.valueOf(1);
	
	private HelloRepository helloRepository;

	@Autowired
	public HelloService(HelloRepository helloWorldRepository) {
		this.helloRepository = helloWorldRepository;
	}
	
	public HelloEntity saveText(String text) {
		HelloEntity entity = new HelloEntity();
		entity.setId(ENTITY_ID);
		entity.setText(text);
		return helloRepository.save(entity);
	}
	
	public String readText() {
		return helloRepository.findById(ENTITY_ID).get().getText();
	}

}
