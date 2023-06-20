package com.example.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import com.example.dtos.HelloWorldDto;

@RedisHash("HelloWorld")
public class HelloWorldDoc {
		
	@Id
    private String id;
    private String text;

	public HelloWorldDoc() {}

	public HelloWorldDoc(HelloWorldDto dto) {
		this.id = dto.getId();
		this.text = dto.getText();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}
