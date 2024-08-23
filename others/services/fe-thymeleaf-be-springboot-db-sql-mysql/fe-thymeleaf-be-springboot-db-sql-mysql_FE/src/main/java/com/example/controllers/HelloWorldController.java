package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.dtos.HelloWorldDto;
import com.example.services.HelloWorldService;

@Controller
public class HelloWorldController {

    private final HelloWorldService helloWorldService;

    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping
    String findById(Model model) {

        HelloWorldDto helloWorldDto = helloWorldService.findById(1L);
        model.addAttribute("message", helloWorldDto.text());
        return "helloworld";

    }

}
