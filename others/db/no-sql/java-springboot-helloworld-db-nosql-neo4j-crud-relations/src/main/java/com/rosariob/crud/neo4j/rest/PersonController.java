package com.rosariob.crud.neo4j.rest;

import com.rosariob.crud.neo4j.domain.Person;
import com.rosariob.crud.neo4j.service.PersonService;
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
@RequestMapping("/api/people")
public class PersonController {
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{personId}")
    public ResponseEntity findById(@PathVariable long personId){
        try {
            return ResponseEntity.ok(personService.findById(personId));
        }
        catch(NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity findAll(){
        try {
            List<Person> found = personService.findAll();
            return ResponseEntity.ok(found);
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createOrReplace(@RequestBody Person person){
        try {
            return ResponseEntity.ok(personService.save(person));
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity deleteById(@PathVariable long personId){
        try {
            personService.deleteById(personId);
            return ResponseEntity.ok().build();
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping()
    public ResponseEntity deleteAll(){
        try {
            personService.deleteAll();
            return ResponseEntity.ok().build();
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
