package com.example.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entities.UserEntity;

@Component
public class UserService {
	
	@Autowired
	ObjectFactory<HttpSession> httpSessionFactory;
	
	public Long save(UserEntity user) {
		
		if (user.getId() == null) {
			return create(user);
		} else {
			return update(user);
		}
		
	}
	
	public Optional<UserEntity> findById(Long id) {
		
		Map<Long, UserEntity> userMap = getUserMap();
		UserEntity user = userMap.get(id);
		return Optional.of(user);
		
	}
	
	public void deleteById(Long id) {
		
		Map<Long, UserEntity> userMap = getUserMap();
		userMap.remove(id);
		
	}
	
	public List<UserEntity> findAll() {
		
		List<UserEntity> users = new ArrayList<>();
		
		Map<Long, UserEntity> userMap = getUserMap();
		for (Long id : userMap.keySet()) {
			users.add(userMap.get(id));
		}
		
		return users;
	}
	
	@SuppressWarnings("unchecked")
	private Map<Long, UserEntity> getUserMap() {
		
		HttpSession session = httpSessionFactory.getObject();
		Map<Long, UserEntity> usersMap = (Map<Long, UserEntity>) session.getAttribute("users");
		if (usersMap == null) {
			usersMap = new LinkedHashMap<>();
		}
		return usersMap;
		
	}
	
	private void saveUserMap(Map<Long, UserEntity> userMap) {
		
		HttpSession session = httpSessionFactory.getObject();
		session.setAttribute("users", userMap);
		
	}
	
	private Long getUserId() {
		
		Long id;
		
		List<UserEntity> users = findAll();
		if (users.isEmpty()) {
			id = Long.valueOf(1);
		} else {
			int tmpId = users.size() + 1;
			id = Long.valueOf(tmpId);
		}
		
		return id;
		
	}
	
	private Long create(UserEntity user) {
		
		Map<Long, UserEntity> userMap = getUserMap();
		Long id = getUserId();		
		user.setId(Long.valueOf(id));
		userMap.put(id, user);	
		saveUserMap(userMap);
		return Long.valueOf(id);
		
	}
	
	private Long update(UserEntity user) {
		
		Map<Long, UserEntity> userMap = getUserMap();
		userMap.put(user.getId(), user);
		return user.getId();
		
	}

}
