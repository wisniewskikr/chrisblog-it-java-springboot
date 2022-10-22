package com.example.app.repositories;

import org.springframework.stereotype.Repository;

import com.example.app.entities.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{}
