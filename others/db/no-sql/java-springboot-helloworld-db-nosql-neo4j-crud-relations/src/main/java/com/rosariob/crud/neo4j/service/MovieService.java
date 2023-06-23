package com.rosariob.crud.neo4j.service;

import com.rosariob.crud.neo4j.domain.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();

    Movie findById(long id);

    Movie save(Movie movie);

    void deleteById(long id);

    void deleteAll();
}
