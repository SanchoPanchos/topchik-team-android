package com.sasha.reviews.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.sasha.reviews.R;
import com.sasha.reviews.adapter.FacultiesAdapter;
import com.sasha.reviews.adapter.TeachersSmallAdapter;
import com.sasha.reviews.contracts.MainContract;
import com.sasha.reviews.model.Course;
import com.sasha.reviews.model.Faculty;
import com.sasha.reviews.model.FirebaseModel;
import com.sasha.reviews.model.Teacher;
import com.sasha.reviews.presenters.MainPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main extends AppCompatActivity implements MainContract.View {

    private ProgressDialog dialog;
    private MainPresenter presenter;

    @BindView(R.id.main_course) ImageView courseImg;
    @BindView(R.id.main_course_name) TextView courseName;
    @BindView(R.id.main_course_reviews) TextView courseReviews;
    @BindView(R.id.main_faculties_list) RecyclerView facultiesList;
    @BindView(R.id.main_lecturers_list) RecyclerView teachersList;
    @BindView(R.id.main_toolbar) Toolbar toolbar;
    @BindView(R.id.main_drawer) DrawerLayout drawer;
    @BindView(R.id.main_navigation_view) NavigationView navigationView;

    private FacultiesAdapter facultiesAdapter;
    private TeachersSmallAdapter teachersAdapter;

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ButterKnife.bind(this);
        presenter = new MainPresenter(this, new FirebaseModel());
        init();
    }

    private void init() {
        initToolbar();
        dialog = new ProgressDialog(Main.this);
        dialog.setMessage("Loading data...");
        dialog.setTitle("Please wait");
        dialog.setCancelable(false);
        courseImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main.this, CourseInfo.class));
            }
        });
        loadData();
    }

    private void initToolbar() {
        toolbar.setTitle("Головна");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
        navigationView.setCheckedItem(R.id.nav_main);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_courses:
                        break;
                    case R.id.nav_faculties:
                        break;
                    case R.id.nav_lecturers:
                        break;
                    case R.id.nav_logout:
                        startActivity(new Intent(Main.this, Start.class));
                        break;
                }
                return false;
            }
        });
    }

    private void loadData() {
        presenter.loadData();
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
    public void onFacultiesLoaded(List<Faculty> faculties) {
        facultiesList.setHasFixedSize(true);
        LinearLayoutManager MyLayoutManager = new LinearLayoutManager(Main.this);
        MyLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        facultiesList.setAdapter(new FacultiesAdapter(this, faculties));
        facultiesList.setLayoutManager(MyLayoutManager);
    }

    @Override
    public void onTeachersLoaded(List<Teacher> teachers) {
        teachersList.setHasFixedSize(true);
        LinearLayoutManager MyLayoutManager = new LinearLayoutManager(Main.this);
        MyLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        teachersList.setAdapter(new TeachersSmallAdapter(this, teachers));
        teachersList.setLayoutManager(MyLayoutManager);
    }

    @Override
    public void onCourseLoaded(Course course) {
        courseName.setText(course.getName());
    }

    @Override
    public void onDataLoaded() {

    }
}
