package com.example.model.dto;

public class MessageDto {
    
    private Long id;
    private String text;    

    public MessageDto(Long id, String text) {
        this.id = id;
        this.text = text;
    }    

    public MessageDto(String text) {
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