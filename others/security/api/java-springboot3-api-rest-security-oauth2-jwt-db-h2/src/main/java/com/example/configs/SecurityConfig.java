package com.example.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.example.filters.JwtAuthFilter;
import com.example.repositories.UserRepository;
import com.example.services.CustomUserDetailsService;
import com.example.services.JwtService;

@Configuration
public class SecurityConfig {
    
    private HandlerExceptionResolver exceptionResolver;
    private UserRepository userRepository;
    private JwtService jwtService;    

    @Autowired
    public SecurityConfig(
            @Qualifier("handlerExceptionResolver") HandlerExceptionResolver exceptionResolver,
            UserRepository userRepository,
            JwtService jwtService) {
        this.exceptionResolver = exceptionResolver;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @Bean
	public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService(userRepository);
    } 
    
    @Bean
    public JwtAuthFilter jwtAuthFilter(){
        return new JwtAuthFilter(jwtService, userDetailsService(), exceptionResolver);
    }

    @Bean
    public PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
	public AuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(bcryptPasswordEncoder());
		return authenticationProvider;

	}

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http            
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .headers(httpSecurityHeadersConfigurer -> {
                httpSecurityHeadersConfigurer.frameOptions(FrameOptionsConfig::disable);
            })
            .authorizeHttpRequests((requests) -> requests
				.requestMatchers("/user").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .requestMatchers("/admin").hasAnyAuthority("ROLE_ADMIN")
                .anyRequest().permitAll()
			)           
            .authenticationProvider(authenticationProvider())
            .addFilterBefore(jwtAuthFilter(), UsernamePasswordAuthenticationFilter.class);            
        
        return http.build();
        
    }

}