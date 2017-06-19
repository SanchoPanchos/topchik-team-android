package com.sasha.reviews.presenters;

import android.util.Log;

import com.sasha.reviews.activities.DepartmentInfo;
import com.sasha.reviews.contracts.DepartmentInfoContract;
import com.sasha.reviews.model.Course;
import com.sasha.reviews.model.FirebaseModel;
import com.sasha.reviews.model.Teacher;

import java.util.List;

public class DepartmentInfoPresenter implements DepartmentInfoContract.Presenter, FirebasePresenter {

    private FirebaseModel model;
    private DepartmentInfoContract.View view;

    public DepartmentInfoPresenter(FirebaseModel model, DepartmentInfoContract.View view) {
        this.model = model;
        this.view = view;
        model.setPresenter(this);
    }

    @Override
    public void loadTeachers(int department) {
        Log.i("TAG", "presenter load");
        model.loadTeacherByDepartment(department);
    }

    @Override
    public void loadCourses() {

    }

    @Override
    public void onTeachersLoaded(List<Teacher> teachers) {
        Log.i("TAG", "presenter loaded " + teachers.size() + " teachers");
        view.onTeachersLoaded(teachers);
    }

    @Override
    public void onCoursesLoaded(List<Course> courses) {

    }
}
