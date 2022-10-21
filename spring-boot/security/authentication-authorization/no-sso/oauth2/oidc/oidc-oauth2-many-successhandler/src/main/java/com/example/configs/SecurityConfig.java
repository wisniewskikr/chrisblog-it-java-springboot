package com.example.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.handlers.CustomOAuth2SuccessHandler;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private CustomOAuth2SuccessHandler customOAuth2SuccessHandler;

    @Autowired
    public SecurityConfig(CustomOAuth2SuccessHandler customOAuth2SuccessHandler) {
		this.customOAuth2SuccessHandler = customOAuth2SuccessHandler;
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
   	
    	http.authorizeRequests()
    		.antMatchers("/helloworld").authenticated();
       
    	http
        	.oauth2Login()
        		.loginPage("/")
        		.successHandler(customOAuth2SuccessHandler);
    	    	
    }

	

		    

}
