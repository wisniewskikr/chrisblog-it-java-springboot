package com.example.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.entities.GreetingEntity;

public interface GreetingRepository extends CrudRepository<GreetingEntity, Long> {}
