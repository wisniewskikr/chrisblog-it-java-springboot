package com.example.utils;

import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.example.enums.UserTypeEnum;

public class UserUtils {
	
	public static UserTypeEnum getUserType(OAuth2UserRequest userRequest) {
		return UserTypeEnum.valueOf(userRequest.getClientRegistration().getRegistrationId().toUpperCase());
	}
	
	public static String getUserName(OAuth2User user) {		
		return (user.getAttribute("email") != null) ? user.getAttribute("email") : user.getAttribute("id"); 		
	}

}
