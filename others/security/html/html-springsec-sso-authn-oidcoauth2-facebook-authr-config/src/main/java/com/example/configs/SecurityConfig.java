package com.example.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    ClientRegistrationRepository clientRegistrationRepository; 

    OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler() { 
        OidcClientInitiatedLogoutSuccessHandler successHandler = new OidcClientInitiatedLogoutSuccessHandler(clientRegistrationRepository);
        successHandler.setPostLogoutRedirectUri("http://localhost:8080/");
        return successHandler;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http            
            .authorizeHttpRequests((requests) -> requests
				.requestMatchers("/user").authenticated()
                .anyRequest().permitAll()
			)
            .oauth2Login(Customizer.withDefaults()) 
            .logout(logout -> logout
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(oidcLogoutSuccessHandler())
            )         
            .exceptionHandling(exception -> exception
                .accessDeniedPage("/access-denied")
            )
            .csrf(Customizer.withDefaults());
        
        return http.build();

    }  

}
