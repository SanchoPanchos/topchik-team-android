package com.sasha.reviews.contracts;


import com.sasha.reviews.model.Course;
import com.sasha.reviews.model.Teacher;

import java.util.List;

public interface DepartmentInfoContract {

    interface View{
        void onTeachersLoaded(List<Teacher> teachers);
        void onCoursesLoaded(List<Course> courses);
    }

    interface Presenter{
        void loadTeachers(int department);
        void loadCourses();
        void onTeachersLoaded(List<Teacher> teachers);
        void onCoursesLoaded(List<Course> courses);
    }
}