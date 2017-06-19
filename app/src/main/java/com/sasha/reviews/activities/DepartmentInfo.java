package com.sasha.reviews.activities;

import android.app.ProgressDialog;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.sasha.reviews.R;
import com.sasha.reviews.contracts.DepartmentInfoContract;
import com.sasha.reviews.fragments.CoursesFragment;
import com.sasha.reviews.fragments.TeachersFragment;
import com.sasha.reviews.model.Course;
import com.sasha.reviews.model.FirebaseModel;
import com.sasha.reviews.model.Teacher;
import com.sasha.reviews.presenters.DepartmentInfoPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DepartmentInfo extends AppCompatActivity implements DepartmentInfoContract.View{

    @BindView(R.id.department_info_tab) TabLayout tabLayout;
    @BindView(R.id.department_info_view_pager) ViewPager viewPager;

    FragmentPagerAdapter adapterViewPager;
    ProgressDialog dialog;
    DepartmentInfoPresenter presenter;
    TeachersFragment teachersFragment = new TeachersFragment();
    CoursesFragment coursesFragment = new CoursesFragment();

    public DepartmentInfoPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.department_info);
        ButterKnife.bind(this);
        presenter = new DepartmentInfoPresenter(new FirebaseModel(), this);
        init();
    }

    private void init() {
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapterViewPager);

        tabLayout.addTab(tabLayout.newTab().setText("Викладачі"));
        tabLayout.addTab(tabLayout.newTab().setText("Предмети"));

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        dialog = new ProgressDialog(DepartmentInfo.this);
        dialog.setTitle("Please wait");
        dialog.setMessage("Loading data...");
        dialog.setCancelable(false);
    }

    @Override
    public void onTeachersLoaded(List<Teacher> teachers) {
        Log.i("TAG", "View on loaded");
        dialog.hide();
        teachersFragment.onTeachersLoaded(teachers);
    }

    @Override
    public void onCoursesLoaded(List<Course> courses) {
        //return courses;
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {
        private final int NUM_ITEMS = 2;
        FragmentManager fragmentManager;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.fragmentManager = fragmentManager;
        }


        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return teachersFragment;
                case 1:
                    return coursesFragment;
                default:
                    return null;
            }
        }
    }
}
