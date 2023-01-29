package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.HelloEntity;

@Repository
public interface HelloRepository extends CrudRepository<HelloEntity, Long> {}
