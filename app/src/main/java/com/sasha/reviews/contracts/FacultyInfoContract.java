package com.sasha.reviews.contracts;


import com.sasha.reviews.model.Department;

import java.util.List;

public interface FacultyInfoContract {

    interface View{
        void showDialog();
        void hideDialog();
        void onDataLoaded(List<Department> departments, String departmentsText, String teachersText, String generalText,
                          String facultyText, String image);
    }

    interface Presenter{
        void loadData(String facultyCode);
        void onDataLoaded(List<Department> departments, String departmentsText, String teachersText, String generalText,
                          String facultyText, String image);
    }

}
