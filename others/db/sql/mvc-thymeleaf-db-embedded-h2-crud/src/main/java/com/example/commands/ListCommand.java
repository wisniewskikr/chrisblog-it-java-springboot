package com.example.commands;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.dtos.UserDto;

public class ListCommand implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<UserDto> users = new ArrayList<UserDto>();
	private Long selectedUserId;

	public List<UserDto> getUsers() {
		return users;
	}
	public void setUsers(List<UserDto> users) {
		this.users = users;
	}
	
	public Long getSelectedUserId() {
		return selectedUserId;
	}
	public void setSelectedUserId(Long selectedUserId) {
		this.selectedUserId = selectedUserId;
	}	
		
}
