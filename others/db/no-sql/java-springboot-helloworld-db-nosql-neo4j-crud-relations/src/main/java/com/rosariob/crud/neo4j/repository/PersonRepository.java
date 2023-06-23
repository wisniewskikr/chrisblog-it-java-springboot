package com.rosariob.crud.neo4j.repository;

import com.rosariob.crud.neo4j.domain.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;


public interface PersonRepository extends Neo4jRepository<Person, Long> {
}
