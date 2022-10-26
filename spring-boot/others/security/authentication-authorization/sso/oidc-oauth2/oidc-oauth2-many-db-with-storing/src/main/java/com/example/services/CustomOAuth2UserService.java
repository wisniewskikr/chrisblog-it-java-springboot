package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.example.entities.UserEntity;
import com.example.enums.UserTypeEnum;
import com.example.repositories.UserRepository;
import com.example.utils.UserUtils;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService  {
	
	private UserRepository userRepository;	
	
	@Autowired
	public CustomOAuth2UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		
		OAuth2User userOAuth2 =  super.loadUser(userRequest);
		String userName = UserUtils.getUserName(userOAuth2);
		UserTypeEnum userType = UserUtils.getUserType(userRequest);
		
		UserEntity user = userRepository.findByUserNameAndUserType(userName, userType);		
		if (user == null) {
			userRepository.save(new UserEntity(userName, null, "USER", userType));
		}				
		
		return userOAuth2;
		
	}	

}
