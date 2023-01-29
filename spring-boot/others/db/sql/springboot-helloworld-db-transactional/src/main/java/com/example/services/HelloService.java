package com.example.services;

import java.util.Optional;

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
		
		HelloEntity result = null;
				
		try {
			HelloEntity entity = new HelloEntity();
			entity.setId(entityId);
			entity.setText(text);
			result = helloRepository.save(entity);
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return result;
		
	}
	
	public String readText(Long entityId) {
		Optional<HelloEntity> entity = helloRepository.findById(entityId);
		return (entity.isPresent()) ? entity.get().getText() : null;
	}

}
