package com.example.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.entities.HelloWorldEntity;

public interface HelloWorldRepository extends CrudRepository<HelloWorldEntity, Long> {}
