package com.example.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.services.CustomOAuth2UserService;
import com.example.services.CustomOidcUserService;
import com.example.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	    
    private CustomUserDetailsService customUserDetailsService;
    private CustomOAuth2UserService auth2UserService;
	private CustomOidcUserService customOidcUserService;
    
    @Autowired
    public SecurityConfig(CustomUserDetailsService customUserDetailsService, CustomOAuth2UserService auth2UserService,
			CustomOidcUserService customOidcUserService) {
		super();
		this.customUserDetailsService = customUserDetailsService;
		this.auth2UserService = auth2UserService;
		this.customOidcUserService = customOidcUserService;
	}    

	@Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
    	return new BCryptPasswordEncoder();
    }    

	@Override
    protected void configure(HttpSecurity http) throws Exception {
   	
    	http.csrf().disable();
    	http.headers().disable();
    	
    	http.authorizeRequests()
    		.antMatchers("/helloworld").hasRole("USER");
        
    	http
        	.formLogin()
        	.loginPage("/")
        	.defaultSuccessUrl("/helloworld", true);
    	
    	http
    		.oauth2Login()
    		.loginPage("/")
    		.defaultSuccessUrl("/helloworld")
    			.userInfoEndpoint().oidcUserService(customOidcUserService)
    		.and()
    			.userInfoEndpoint().userService(auth2UserService);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
    	auth
			.userDetailsService(customUserDetailsService)
			.passwordEncoder(getBCryptPasswordEncoder());
    	        
    }    

}
