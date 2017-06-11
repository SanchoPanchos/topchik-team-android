package com.sasha.reviews.model;

import java.util.List;

public class Teacher {

    private String about;
    private List<String> coursesIDs;
    private String email;
    private String image;
    private String name;
    private String nameShort;
    private int departmentID;

    public Teacher(){

    }

    public String getNameShort() {
        return nameShort;
    }

    public Teacher(String about, List<String> coursesIDs, String email, String image, String name, int departmentID) {
        this.about = about;
        this.coursesIDs = coursesIDs;
        this.email = email;
        this.image = image;
        this.name = name;
        this.nameShort = getShortName(name);

        this.departmentID = departmentID;
    }

    public String getAbout() {
        return about;
    }

    public String getShortName(String name){
        return name.substring(0, name.indexOf(" ") + 1) +
                name.charAt(name.indexOf(" ") + 1) + "." +
                name.charAt(name.indexOf(" ", name.indexOf(" ") + 1) + 1) + ".";
    }


    public List<String> getCoursesIDs() {
        return coursesIDs;
    }

    public String getEmail() {
        return email;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public int getDepartmentID() {
        return departmentID;
    }
}
