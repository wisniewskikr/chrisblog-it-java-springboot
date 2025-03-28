package com.example.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200/")
public class HelloWorldController {
    
    @GetMapping("/public")
    public String helloPublic() {
        return "Hello World, Public!";
    }

    @GetMapping("/secured")
    public String helloSecured() {
        return "Hello World, Secured!";
    }
    
}
