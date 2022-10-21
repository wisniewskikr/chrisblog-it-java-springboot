package com.example.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.services.CustomOAuth2UserService;
import com.example.services.CustomOidcUserService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private CustomOAuth2UserService auth2UserService;
	private CustomOidcUserService customOidcUserService;

    @Autowired
    public SecurityConfig(CustomOAuth2UserService auth2UserService, CustomOidcUserService customOidcUserService) {
		this.auth2UserService = auth2UserService;
		this.customOidcUserService = customOidcUserService;
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
   	
    	http.authorizeRequests()
    		.antMatchers("/helloworld").authenticated();
       
    	http
        	.oauth2Login()
        		.loginPage("/")
        		.defaultSuccessUrl("/helloworld")
        			.userInfoEndpoint().oidcUserService(customOidcUserService)
        		.and()
        			.userInfoEndpoint().userService(auth2UserService);
    	    	
    }

		    

}
