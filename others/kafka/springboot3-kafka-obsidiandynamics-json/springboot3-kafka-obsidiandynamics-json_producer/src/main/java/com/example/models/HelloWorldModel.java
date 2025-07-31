package com.example.models;

public class HelloWorldModel {

    private String message;

    public HelloWorldModel() {
    }

    public HelloWorldModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
