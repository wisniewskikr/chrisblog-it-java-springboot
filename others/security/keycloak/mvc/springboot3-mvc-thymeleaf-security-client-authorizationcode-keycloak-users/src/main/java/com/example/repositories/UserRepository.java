package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

    UserEntity findByUserName(String userName);

}