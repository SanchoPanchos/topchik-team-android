package com.sasha.reviews.contracts;

import com.sasha.reviews.model.Faculty;
import com.sasha.reviews.model.Teacher;
import com.sasha.reviews.model.Course;

import java.util.List;

public interface MainContract {

    interface View{
        void showDialog();
        void hideDialog();
        void onFacultiesLoaded(List<Faculty> faculties);
        void onTeachersLoaded(List<Teacher> teachers);
        void onCourseLoaded(Course course);
        void onDataLoaded();
    }

    interface Presenter{
        void loadData();
        void loadFaculties();
        void loadTeachers();
        void loadCourse();
        void onFacultiesLoaded(List<Faculty> faculties);
        void onTeachersLoaded(List<Teacher> teachers);
        void onCourseLoaded(Course course);
        void onDataLoaded();
    }
}
