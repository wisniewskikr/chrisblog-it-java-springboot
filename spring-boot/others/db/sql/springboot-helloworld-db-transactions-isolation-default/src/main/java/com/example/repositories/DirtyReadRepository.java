package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.DirtyReadEntity;

@Repository
public interface DirtyReadRepository extends CrudRepository<DirtyReadEntity, Long> {}
