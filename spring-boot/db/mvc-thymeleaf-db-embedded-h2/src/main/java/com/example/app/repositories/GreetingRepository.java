package com.example.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.app.entities.GreetingEntity;

public interface GreetingRepository extends CrudRepository<GreetingEntity, Long> {}
