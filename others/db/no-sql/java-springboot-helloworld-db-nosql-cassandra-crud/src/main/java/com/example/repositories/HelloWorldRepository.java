package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.documents.HelloWorldDoc;

@Repository
public interface HelloWorldRepository extends CrudRepository<HelloWorldDoc, String> {}
