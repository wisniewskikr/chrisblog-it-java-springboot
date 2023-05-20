package com.example.configs;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import com.example.filters.ApiKeyFilter;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@Configuration
public class SecurityConfig {

    @Value("${api.key.name}")
    private String apiKeyName;

    @Value("${api.key.value.user}")
    private String apiKeyValueUser;

    @Value("${api.key.value.admin}")
    private String apiKeyValueAdmin;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
			.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/").permitAll()
                .requestMatchers("/user", "/admin")
                .authenticated()
			)
            .addFilter(getFilter())
            .csrf(Customizer.withDefaults())
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            );
        
        return http.build();
        
    }
	
	private ApiKeyFilter getFilter() {
    	
    	ApiKeyFilter filter = new ApiKeyFilter(apiKeyName);
    	
        filter.setAuthenticationManager(new AuthenticationManager() {

            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {

                String principal = (String) authentication.getPrincipal();
                String path = (String) authentication.getCredentials();
                boolean pathSecured = isPathSecured(path);
                ArrayList<String> apiKeyValues = getApiKeyValues(path);

                if (pathSecured && !apiKeyValues.contains(principal)) {
                    throw new BadCredentialsException("The API key was not found or not the expected value.");
                }
                authentication.setAuthenticated(true);
                return authentication;

            }

        });
        
        return filter;
    	
    }
    
    private boolean isPathSecured(String path) {

        if ("/user".equals(path) || "/admin".equals(path)) {
            return true;
        }

        return false;

    }

    private ArrayList<String> getApiKeyValues(String path) {

        ArrayList<String> apiKeyValues = new ArrayList<String>();

        if ("/user".equals(path)) {
            apiKeyValues.add(apiKeyValueUser);
            apiKeyValues.add(apiKeyValueAdmin);
        }

        if ("/admin".equals(path)) {  
            apiKeyValues.add(apiKeyValueAdmin);
        }

        return apiKeyValues;

    }

}