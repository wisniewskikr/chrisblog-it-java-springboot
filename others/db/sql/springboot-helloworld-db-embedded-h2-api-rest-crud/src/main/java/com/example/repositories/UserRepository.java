package com.example.repositories;

import org.springframework.stereotype.Repository;
import com.example.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{}
