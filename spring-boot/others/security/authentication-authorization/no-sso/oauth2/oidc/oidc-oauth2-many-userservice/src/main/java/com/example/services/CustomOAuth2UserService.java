package com.example.services;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService  {

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		
		System.out.println("***** CustomOAuth2UserService *****" );
		
		OAuth2User user =  super.loadUser(userRequest);
		
		Map<String, Object> attributes = user.getAttributes();
		Set<String> keys = attributes.keySet();
		for (String key : keys) {
			System.out.println("ATTRIBURE - Key: " + key + "; Value: " + attributes.get(key));
		}
		
		Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			System.out.println("GRANTEDAUTHORITY - Name: " + grantedAuthority.getAuthority());
		}
		
		return user;
		
	}

}
