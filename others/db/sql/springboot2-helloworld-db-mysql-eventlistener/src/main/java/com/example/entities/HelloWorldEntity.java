package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HELLOWORLD")
public class HelloWorldEntity {

    @Id
    private Long id;
    private String text;

    public HelloWorldEntity() {}

    public HelloWorldEntity(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }    

}