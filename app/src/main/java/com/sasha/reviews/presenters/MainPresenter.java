package com.sasha.reviews.presenters;

import com.sasha.reviews.contracts.MainContract;
import com.sasha.reviews.model.Course;
import com.sasha.reviews.model.Faculty;
import com.sasha.reviews.model.FirebaseModel;
import com.sasha.reviews.model.Teacher;

import java.util.List;

public class MainPresenter implements MainContract.Presenter, FirebasePresenter{

    private MainContract.View view;
    private FirebaseModel model;

    public MainPresenter(MainContract.View view, FirebaseModel model) {
        this.view = view;
        this.model = model;
        model.setPresenter(this);
    }

    @Override
    public void loadData() {
        loadFaculties();
    }

    @Override
    public void loadFaculties() {
        view.showDialog();
        model.loadFaculties();
    }

    @Override
    public void loadTeachers() {
        model.loadTeachersSmall();
    }

    @Override
    public void loadCourse() {
        model.loadCourse();
    }

    @Override
    public void onFacultiesLoaded(List<Faculty> faculties) {
        view.onFacultiesLoaded(faculties);
        loadTeachers();
    }

    @Override
    public void onTeachersLoaded(List<Teacher> teachers) {
        view.onTeachersLoaded(teachers);
        loadCourse();
    }

    @Override
    public void onCourseLoaded(Course course) {
        view.onCourseLoaded(course);
        onDataLoaded();
    }

    @Override
    public void onDataLoaded() {
        view.hideDialog();
        view.onDataLoaded();
    }
}
