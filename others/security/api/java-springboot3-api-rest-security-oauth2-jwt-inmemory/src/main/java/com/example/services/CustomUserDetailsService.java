package com.example.services;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entities.UserEntity;
import com.example.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    private UserRepository userRepository;    

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        
        UserEntity user = userRepository.findByUserName(userName);

        return User
            .builder()
            .username(user.getUserName())
            .password(user.getPassword())
            .authorities( Arrays.stream(
                        user.getRoles()
                        .split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList()))
            .build();        

    }

}