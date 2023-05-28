package com.example.jsons;

public class UserJson {

    private String name;
    private String password;

    public UserJson() {}

    public UserJson(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }    
    
}