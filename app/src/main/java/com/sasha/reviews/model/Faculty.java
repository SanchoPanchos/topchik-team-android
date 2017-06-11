package com.sasha.reviews.model;


import java.util.List;

public class Faculty {

    private String about;
    private String name;
    private String img;
    private String nameShort;
    private List<Department> departments;

    public Faculty(String about, String name, String nameShort, String img, List<Department> departments) {
        this.about = about;
        this.name = name;
        this.nameShort = nameShort;
        this.img = img;
        this.departments = departments;
    }

    public String getNameShort() {
        return nameShort;
    }

    public String getAbout() {
        return about;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public List<Department> getDepartments() {
        return departments;
    }
}
