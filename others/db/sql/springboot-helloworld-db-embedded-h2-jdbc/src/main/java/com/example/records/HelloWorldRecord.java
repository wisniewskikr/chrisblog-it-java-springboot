package com.example.records;

import org.springframework.data.annotation.Id;

public record HelloWorldRecord(@Id Long id, String text) { }
