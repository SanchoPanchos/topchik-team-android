package com.sasha.reviews.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.sasha.reviews.R;
import com.sasha.reviews.adapters.DepartmentsAdapter;
import com.sasha.reviews.contracts.FacultyInfoContract;
import com.sasha.reviews.model.Department;
import com.sasha.reviews.model.FirebaseModel;
import com.sasha.reviews.presenters.FacultyInfoPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FacultyInfo extends AppCompatActivity implements FacultyInfoContract.View{

    @BindView(R.id.faculty_info_departments_list) ListView departmentsList;
    @BindView(R.id.faculty_info_faculty_text) TextView facultyText;
    @BindView(R.id.faculty_info_general_text) ExpandableTextView generalText;
    @BindView(R.id.faculty_info_image) ImageView facultyImage;
    @BindView(R.id.faculty_info_teachers_text) TextView teachersText;
    @BindView(R.id.faculty_info_toolbar) Toolbar toolbar;
    @BindView(R.id.faculty_info_departments_text) TextView departmentsText;
    @BindView(R.id.faculty_info_drawer) DrawerLayout drawer;
    @BindView(R.id.faculty_info_navigation_view) NavigationView navigationView;

    DepartmentsAdapter departmentsAdapter;
    ProgressDialog dialog;
    FacultyInfoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faculty_info);
        ButterKnife.bind(this);
        presenter = new FacultyInfoPresenter(new FirebaseModel(), this);
        init();
    }

    private void init() {
        initToolbar();
        dialog = new ProgressDialog(FacultyInfo.this);
        dialog.setMessage("Loading data");
        dialog.setTitle("Please wait");
        dialog.setCancelable(false);
//
//        generalText.setOnExpandStateChangeListener(new ExpandableTextView.OnExpandStateChangeListener() {
//            @Override
//            public void onExpandStateChanged(TextView textView, boolean isExpanded) {
//                Toast.makeText(FacultyInfo.this, isExpanded ? "Expanded" : "Collapsed", Toast.LENGTH_SHORT).show();
//            }
//        });

        presenter.loadData(getIntent().getExtras().getString("FacultyCode", ""));
    }

    private void initToolbar() {
        toolbar.setTitle(getIntent().getExtras().getString("FacultyName", ""));
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FacultyInfo.this, Main.class));
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.open, R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawer.addDrawerListener(toggle);
        navigationView.setCheckedItem(R.id.nav_faculties);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_courses:
                        break;
                    case R.id.nav_main:
                        startActivity(new Intent(FacultyInfo.this, Main.class));
                        break;
                    case R.id.nav_faculties:
                        break;
                    case R.id.nav_lecturers:
                        break;
                    case R.id.nav_logout:
                        startActivity(new Intent(FacultyInfo.this, Start.class));
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public void showDialog() {
        dialog.show();
    }

    @Override
    public void hideDialog() {
        dialog.hide();
    }

    @Override
    public void onDataLoaded(final List<Department> departments, String mDepartmentsText, String mTeachersText,
                             String mGeneralText, String mFacultyText, String image) {
        Glide.with(this).load(image).into(facultyImage);
        departmentsAdapter = new DepartmentsAdapter(departments, FacultyInfo.this);
        departmentsList.setAdapter(departmentsAdapter);
        departmentsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                startActivity(new Intent(FacultyInfo.this, DepartmentInfo.class)
                .putExtra("Department", departments.get(position).getDepartmentCode()));
            }
        });
        departmentsText.setText(mDepartmentsText);
        teachersText.setText(mTeachersText);
        generalText.setText(mGeneralText);
        facultyText.setText(mFacultyText);
    }
}
