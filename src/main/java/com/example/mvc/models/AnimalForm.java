package com.example.mvc.models;

public class AnimalForm {
    private String name;
    private String adjective;

    public AnimalForm() { }

    public AnimalForm(String name, String adjective) {
        this.name = name;
        this.adjective = adjective;
    }

    public String getName() {
        return name;
    }

    public String getAdjective() {
        return adjective;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdjective(String adjective) {
        this.adjective = adjective;
    }
}
