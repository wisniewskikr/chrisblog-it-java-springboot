package com.example.commands;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.entities.UserEntity;

public class ListCommand implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<UserEntity> users = new ArrayList<UserEntity>();
	private Long selectedUserId;

	public List<UserEntity> getUsers() {
		return users;
	}
	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	
	public Long getSelectedUserId() {
		return selectedUserId;
	}
	public void setSelectedUserId(Long selectedUserId) {
		this.selectedUserId = selectedUserId;
	}	
		
}
