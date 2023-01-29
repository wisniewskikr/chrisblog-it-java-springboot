package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.WorldEntity;

@Repository
public interface WorldRepository extends CrudRepository<WorldEntity, Long> {}
