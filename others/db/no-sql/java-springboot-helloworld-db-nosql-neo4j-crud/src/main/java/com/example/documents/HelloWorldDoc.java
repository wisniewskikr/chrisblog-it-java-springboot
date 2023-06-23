package com.example.documents;


import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import com.example.dtos.HelloWorldDto;

@Node
public class HelloWorldDoc {
		
	@Id @GeneratedValue
    private Long id;
    private String text;

	public HelloWorldDoc() {}

	public HelloWorldDoc(HelloWorldDto dto) {
		this.id = dto.getId();
		this.text = dto.getText();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}
