package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.DirtyReadEntity;

@Repository
public interface DirtyReadRepository extends JpaRepository<DirtyReadEntity, Long> {}
