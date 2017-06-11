package com.sasha.reviews.model;


class TeacherDep {
    private String teacherID;
    private String departmentID;

    public TeacherDep(String teacherID, String departmentID) {
        this.teacherID = teacherID;
        this.departmentID = departmentID;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public String getDepartmentID() {
        return departmentID;
    }
}
