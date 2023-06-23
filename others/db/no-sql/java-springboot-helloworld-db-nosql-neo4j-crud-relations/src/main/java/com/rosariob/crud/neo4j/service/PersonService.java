package com.rosariob.crud.neo4j.service;

import com.rosariob.crud.neo4j.domain.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();

    Person findById(long id);

    Person save(Person Person);

    void deleteById(long id);

    void deleteAll();
}
