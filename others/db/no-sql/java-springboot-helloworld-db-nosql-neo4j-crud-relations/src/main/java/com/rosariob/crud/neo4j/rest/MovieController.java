package com.rosariob.crud.neo4j.rest;

import com.rosariob.crud.neo4j.domain.Movie;
import com.rosariob.crud.neo4j.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{movieId}")
    public ResponseEntity findById(@PathVariable long movieId){
        try {
            return ResponseEntity.ok(movieService.findById(movieId));
        }
        catch(NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity findAll() {
        try {
            List<Movie> found = movieService.findAll();
            return ResponseEntity.ok(found);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createOrUpdate(@RequestBody Movie movie) {
        try {
            return ResponseEntity.ok(movieService.save(movie));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity deleteById(@PathVariable long movieId){
        try {
            movieService.deleteById(movieId);
            return ResponseEntity.ok().build();
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping()
    public ResponseEntity deleteAll(){
        try {
            movieService.deleteAll();
            return ResponseEntity.ok().build();
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
