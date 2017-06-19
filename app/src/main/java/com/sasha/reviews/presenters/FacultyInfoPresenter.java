package com.sasha.reviews.presenters;

import com.sasha.reviews.contracts.FacultyInfoContract;
import com.sasha.reviews.model.Department;
import com.sasha.reviews.model.FirebaseModel;

import java.util.List;

public class FacultyInfoPresenter implements FirebasePresenter, FacultyInfoContract.Presenter {

    private FirebaseModel model;
    private FacultyInfoContract.View view;

    public FacultyInfoPresenter(FirebaseModel model, FacultyInfoContract.View view) {
        this.model = model;
        this.view = view;
        model.setPresenter(this);
    }

    @Override
    public void loadData(String facultyCode) {
        view.showDialog();
        model.loadFacultyData(facultyCode);
    }

    @Override
    public void onDataLoaded(List<Department> departments, String departmentsText, String teachersText, String generalText, String facultyText, String image) {
        view.hideDialog();
        view.onDataLoaded(departments, "Кафедр: " + departmentsText, "Викладачів: " + teachersText,
                generalText, facultyText, image);
    }
}
