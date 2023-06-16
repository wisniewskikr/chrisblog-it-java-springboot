package com.example.dtos;

import com.example.entities.UserEntity;

public class UserDto {	

	private Long id;	
	private String name;
	
	public UserDto() {}
	
	public UserDto(String name) {
		this.name = name;
	}	
	
	public UserDto(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public UserDto(UserEntity userEntity) {
		this.id = userEntity.getId();
		this.name = userEntity. getName();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	

}