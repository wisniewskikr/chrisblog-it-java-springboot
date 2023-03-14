package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.WordEntity;

@Repository
public interface WordRepository extends CrudRepository<WordEntity, Long> {}
