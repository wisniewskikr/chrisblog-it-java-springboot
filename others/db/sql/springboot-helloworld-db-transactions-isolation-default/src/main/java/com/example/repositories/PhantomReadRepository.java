package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.PhantomReadEntity;

@Repository
public interface PhantomReadRepository extends JpaRepository<PhantomReadEntity, Long> {}
