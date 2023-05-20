package com.example.services;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

@Service
public class CustomOidcUserService extends OidcUserService {

	@Override
	public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
		
		System.out.println("***** CustomOidcUserService *****" );
		
		OidcUser user = super.loadUser(userRequest);
		
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
