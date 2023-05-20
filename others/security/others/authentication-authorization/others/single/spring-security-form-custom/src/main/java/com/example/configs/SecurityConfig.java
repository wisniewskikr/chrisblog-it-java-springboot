package com.example.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Value(value = "${basic.username.user}")
    private String usernameUser;
	@Value(value = "${basic.password.user}")
    private String passwordUser;
	@Value(value = "${basic.username.admin}")
    private String usernameAdmin;
	@Value(value = "${basic.password.admin}")
    private String passwordAdmin;

	@Bean
    public PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {		
		
        UserDetails user = User
        	.withUsername(usernameUser)
            .password(bcryptPasswordEncoder().encode(passwordUser))
            .roles("USER")
            .build();
        
        UserDetails admin = User
            	.withUsername(usernameAdmin)
                .password(bcryptPasswordEncoder().encode(passwordAdmin))
                .roles("ADMIN")
                .build();
        
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(user);
        manager.createUser(admin);
        
        return manager;
        
    }
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
        	.authorizeRequests((authReq) -> authReq
        		.antMatchers("/user").hasAnyRole("USER", "ADMIN")
        		.antMatchers("/admin").hasRole("ADMIN")
        	);  
		
		http
			.formLogin()
			.loginPage("/login");
		
		http
			.logout()
			.logoutUrl("/logout");
		
		http.exceptionHandling().accessDeniedPage("/access-denied");
        
        return http.build();
        
    }

}
