package com.example.entities;

import com.example.dtos.UserDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USERS")
public class UserEntity {	

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	public UserEntity() {}
	
	public UserEntity(String name) {
		this.name = name;
	}	
	
	public UserEntity(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public UserEntity(UserDto userDto) {
		this.id = userDto.getId();
		this.name = userDto.getName();
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
