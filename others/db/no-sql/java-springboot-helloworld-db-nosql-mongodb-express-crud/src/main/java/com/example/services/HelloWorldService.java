package com.example.services;

import java.util.ArrayList;
import java.util.List;
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
	
	public HelloWorldDto findById(String id) {
		Optional<HelloWorldDoc> optHelloWorldDoc = helloWorldRepository.findById(id);
		return new HelloWorldDto(optHelloWorldDoc.orElseThrow((() -> new RuntimeException("There is no document with id: " + id))));
	}

	public List<HelloWorldDto> findAll() {
		List<HelloWorldDto> list = new ArrayList<HelloWorldDto>();
		Iterable<HelloWorldDoc> it = helloWorldRepository.findAll();
		it.forEach(doc -> list.add(new HelloWorldDto(doc)));
		return list;		
	}

	public String deleteById(String id) {
		helloWorldRepository.deleteById(id);
		return "Deleted";
	}

}
