package com.rosariob.crud.neo4j.service;

import com.rosariob.crud.neo4j.domain.Movie;
import com.rosariob.crud.neo4j.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{
    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    
    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(long id) {
        return movieRepository.findById(id).orElseThrow();
    }

    @Transactional
    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }
    
    @Transactional
    @Override
    public void deleteById(long id) {
        movieRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteAll() {
        movieRepository.deleteAll();
    }
}
