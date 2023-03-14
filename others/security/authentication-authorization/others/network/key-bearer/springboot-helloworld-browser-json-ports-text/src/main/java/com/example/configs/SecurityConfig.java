package com.example.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.authentication.BadCredentialsException;

import com.example.filters.ApiKeyBearerFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	private static final String BEARER_HEADER = "Bearer";

    @Value("${bearer.token}")
    private String bearerToken;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {        
        
        httpSecurity
            .antMatcher("/")
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .addFilter(getFilter())
            .authorizeRequests().anyRequest().authenticated();
        
    }
    
    private ApiKeyBearerFilter getFilter() {
    	
    	ApiKeyBearerFilter filter = new ApiKeyBearerFilter();
    	
        filter.setAuthenticationManager(authentication -> {
		    String principal = (String) authentication.getPrincipal();
		    boolean containsBearer = principal.contains(BEARER_HEADER);
		    String token = principal.replace(BEARER_HEADER + " ", "");		    
		    if (!containsBearer || !bearerToken.equals(token)) {
		        throw new BadCredentialsException("The Bearer Token was not found or not the expected value.");
		    }
		    authentication.setAuthenticated(true);
		    return authentication;
          });
        
        return filter;
    	
    }    

}
