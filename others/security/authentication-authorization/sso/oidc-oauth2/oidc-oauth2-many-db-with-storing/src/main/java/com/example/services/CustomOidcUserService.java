package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import com.example.entities.UserEntity;
import com.example.enums.UserTypeEnum;
import com.example.repositories.UserRepository;
import com.example.utils.UserUtils;

@Service
public class CustomOidcUserService extends OidcUserService {
	
	private UserRepository userRepository;	
	
	@Autowired
	public CustomOidcUserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
		
		OidcUser userOcid = super.loadUser(userRequest);
		String userName = UserUtils.getUserName(userOcid);
		UserTypeEnum userType = UserUtils.getUserType(userRequest);
		
		UserEntity user = userRepository.findByUserNameAndUserType(userName, userType);		
		if (user == null) {
			userRepository.save(new UserEntity(userName, null, "USER", userType));
		}			
		
		return userOcid;
		
	}
	
	

}
