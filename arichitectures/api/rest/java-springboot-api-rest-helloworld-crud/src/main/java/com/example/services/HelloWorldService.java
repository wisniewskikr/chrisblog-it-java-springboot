package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.models.HelloWorldModel;

@Service
public class HelloWorldService {

	private List<HelloWorldModel> messages = new ArrayList<HelloWorldModel>();
	
	public String save(HelloWorldModel helloWorldModel) {

		Objects.requireNonNull(helloWorldModel.getId(), "Message requires argument 'id'");
		Objects.requireNonNull(helloWorldModel.getText(), "Message requires argument 'text'");

		String result = "Message was updated";	

		try {
			deleteById(helloWorldModel.getId());
		} catch (Exception e) {
			result = "New Message was added";
		}

		messages.add(helloWorldModel);

		return result;

	}
	
	public HelloWorldModel findById(Long id) {
		return messages.stream().filter((message) -> message.getId() == id).findFirst()
			.orElseThrow((() -> new RuntimeException("There is no message with id: " + id)));
	}

	public List<HelloWorldModel> findAll() {
		return messages;	
	}

	public String deleteById(Long id) {
		boolean result = messages.removeIf(message -> message.getId() == id);
		if (!result) {
			throw new RuntimeException("There is no message with id: " + id);
		} 
		return "Message was deleted"; 
	}

}
