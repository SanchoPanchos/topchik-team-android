package com.sasha.reviews.model;

import java.util.List;

public class Course {

    private String about;
    private int credits;
    private int hours;
    private List<String> teachers;
    private String name;

    public Course(String about, int credits, int hours, List<String> teachers, String name) {
        this.about = about;
        this.credits = credits;
        this.hours = hours;
        this.teachers = teachers;
        this.name = name;
    }

    public Course(){

    }

    public String getAbout() {
        return about;
    }

    public int getCredits() {
        return credits;
    }

    public int getHours() {
        return hours;
    }

    public List<String> getTeachers() {
        return teachers;
    }

    public String getName() {
        return name;
    }
}
