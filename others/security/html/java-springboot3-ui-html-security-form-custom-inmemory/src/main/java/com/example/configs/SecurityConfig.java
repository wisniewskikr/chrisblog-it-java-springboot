package com.example.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Value(value = "${username.user}")
    private String usernameUser;
	@Value(value = "${password.user}")
    private String passwordUser;
	@Value(value = "${username.admin}")
    private String usernameAdmin;
	@Value(value = "${password.admin}")
    private String passwordAdmin;

	@Bean
    public PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

     @Bean
	public UserDetailsService userDetailsService() {

        UserDetails user = User.builder()
		    .username(usernameUser)
		    .password(bcryptPasswordEncoder().encode(passwordUser))
		    .roles("USER")
		    .build();
	    
        UserDetails admin = User.builder()
		    .username(usernameAdmin)
		    .password(bcryptPasswordEncoder().encode(passwordAdmin))
		    .roles("USER", "ADMIN")
		    .build();
	    
        return new InMemoryUserDetailsManager(user, admin);

    }
    
    @Bean
	public AuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(bcryptPasswordEncoder());
		return authenticationProvider;

	}

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http            
            .authorizeHttpRequests((requests) -> requests
				.requestMatchers("/user").hasAnyRole("USER", "ADMIN")
                .requestMatchers("/admin").hasAnyRole("ADMIN")
                .anyRequest().permitAll()
			)
            .formLogin(login -> 
                login
                    .loginPage("/login"))
            .logout(logout -> 
                logout
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .permitAll()
            )
            .exceptionHandling(exception -> exception
                .accessDeniedPage("/access-denied")
            )
            .csrf(Customizer.withDefaults())
            .authenticationProvider(authenticationProvider());
        
        return http.build();
        
    }

}