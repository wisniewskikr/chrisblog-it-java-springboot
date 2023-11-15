package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.records.HelloWorldRecord;

@Repository
public interface HelloWorldRepository extends CrudRepository<HelloWorldRecord, Long> {}
