package com.example.listeners;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.entities.UserEntity;
import com.example.repositories.UserRepository;

@Component
public class LoadUsersListener {
    
    private UserRepository userRepository;

    @Autowired
    public LoadUsersListener(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @EventListener
    public void loadUsers() {

        List<UserEntity> users = Stream.of(
                new UserEntity(1L, "user", new BCryptPasswordEncoder().encode("user123"), "USER_ROLE"),
                new UserEntity(2L, "admin", new BCryptPasswordEncoder().encode("admin123"), "USER_ROLE,ADMIN_ROLE")
        ).collect(Collectors.toList());
        userRepository.saveAll(users);

    }    

}