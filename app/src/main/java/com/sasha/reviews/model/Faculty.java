package com.sasha.reviews.model;


import java.util.List;

public class Faculty {

    private String about;
    private String name;
    private String img;
    private String nameShort;
    private String code;
    private List<Department> departments;

    public Faculty(String about, String name, String img, String nameShort, String code, List<Department> departments) {
        this.about = about;
        this.name = name;
        this.img = img;
        this.nameShort = nameShort;
        this.code = code;
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

    public String getCode() {
        return code;
    }
}
