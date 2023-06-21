package com.example.repositories;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.example.documents.HelloWorldDoc;

@Repository
public interface HelloWorldRepository extends CassandraRepository<HelloWorldDoc, String> {}
