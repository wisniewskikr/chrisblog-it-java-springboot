package com.example.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Value(value = "${digest.username}")
    private String digestUsername;
    @Value(value = "${digest.password}")
    private String digestPassword;
    @Value(value = "${digest.reamlname}")
    private String digestRealmName;
    @Value(value = "${digest.key}")
    private String digestKey;
    
  @Override
  protected void configure(HttpSecurity http) throws Exception {
 	
  	http.authorizeRequests()
  		.antMatchers("/").hasRole("USER")
      .and()
      	.csrf().disable()
      	.addFilter(getDigestAuthFilter())
      	.exceptionHandling().authenticationEntryPoint(getDigestEntryPoint());

  }
    
    public DigestAuthenticationFilter getDigestAuthFilter() throws Exception {
	
    	DigestAuthenticationFilter digestAuthenticationFilter = new DigestAuthenticationFilter();
    	digestAuthenticationFilter.setUserDetailsService(userDetailsServiceBean());
    	digestAuthenticationFilter.setAuthenticationEntryPoint(getDigestEntryPoint());
    	return digestAuthenticationFilter;
	
    }
    
    private DigestAuthenticationEntryPoint getDigestEntryPoint() {
    	
    	DigestAuthenticationEntryPoint entryPoint = new DigestAuthenticationEntryPoint();
    	entryPoint.setRealmName(digestRealmName);
    	entryPoint.setKey(digestKey);
    	return entryPoint;
    	
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
        auth.inMemoryAuthentication()
                .withUser(digestUsername).password(digestPassword).roles("USER");
        
    }

	@Override
	@Bean
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return super.userDetailsServiceBean();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
    

}
