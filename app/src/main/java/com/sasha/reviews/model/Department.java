package com.sasha.reviews.model;

public class Department {

    private int departmentCode;
    private String name;

    public Department(int departmentCode, String name) {
        this.departmentCode = departmentCode;
        this.name = name;
    }

    public int getDepartmentCode() {
        return departmentCode;
    }

    public String getName() {
        return name;
    }
}
