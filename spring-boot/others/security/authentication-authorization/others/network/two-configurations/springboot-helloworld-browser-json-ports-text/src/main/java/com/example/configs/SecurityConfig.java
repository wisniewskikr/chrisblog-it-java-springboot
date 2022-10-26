package com.example.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.example.filters.ApiKeyFilter;


@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Configuration
	@Order(1)
	public class ApiKeyConfig extends WebSecurityConfigurerAdapter {
		
		@Value("${api.key.name}")
	    private String apiKeyName;

	    @Value("${api.key.value}")
	    private String apiKeyValue;

	    @Override
	    protected void configure(HttpSecurity httpSecurity) throws Exception {        
	        
	        httpSecurity
	            .antMatcher("/apikey")
	            .csrf().disable()
	            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	            .and()
	            .addFilter(getFilter())
	            .authorizeRequests().anyRequest().authenticated();
	        
	    }
	    
	    private ApiKeyFilter getFilter() {
	    	
	    	ApiKeyFilter filter = new ApiKeyFilter(apiKeyName);
	    	
	        filter.setAuthenticationManager(new AuthenticationManager() {
	            @Override
	            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	                String principal = (String) authentication.getPrincipal();
	                if (!apiKeyValue.equals(principal))
	                {
	                    throw new BadCredentialsException("The API key was not found or not the expected value.");
	                }
	                authentication.setAuthenticated(true);
	                return authentication;
	            }
	        });
	        
	        return filter;
	    	
	    }  
		
	}
	
	@Configuration
	@Order(2)
	public class BasicConfig extends WebSecurityConfigurerAdapter {
		
		@Value(value = "${basic.username}")
	    private String basicUsername;
	    @Value(value = "${basic.password}")
	    private String basicPassword;
		

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	   	
	    	http.authorizeRequests()
	    		.antMatchers("/basic").hasRole("USER")
	    		.anyRequest().authenticated()
	        .and()
	        	.httpBasic()
	        .and()
	        	.csrf().disable();

	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    	
	        auth.inMemoryAuthentication()
	                .withUser(basicUsername).password("{noop}"+basicPassword).roles("USER");
	        
	    }	    
	    
	}    
      

}
