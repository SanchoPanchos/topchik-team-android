package com.sasha.reviews.model;

public class Teacher {

    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Teacher(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
