package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.HelloEntity;
import com.example.repositories.HelloRepository;

@Service
public class HelloService {	
	
	private HelloRepository helloRepository;

	@Autowired
	public HelloService(HelloRepository helloWorldRepository) {
		this.helloRepository = helloWorldRepository;
	}
	
	public HelloEntity saveText(Long entityId, String text) {
		HelloEntity entity = new HelloEntity();
		entity.setId(entityId);
		entity.setText(text);
		return helloRepository.save(entity);
	}
	
	public String readText(Long entityId) {
		return helloRepository.findById(entityId).get().getText();
	}

}
