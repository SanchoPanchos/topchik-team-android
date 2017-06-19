package com.sasha.reviews.model;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sasha.reviews.presenters.DepartmentInfoPresenter;
import com.sasha.reviews.presenters.FacultyInfoPresenter;
import com.sasha.reviews.presenters.FirebasePresenter;
import com.sasha.reviews.presenters.MainPresenter;
import com.sasha.reviews.presenters.RegisterPresenter;
import com.sasha.reviews.presenters.StartPresenter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class FirebaseModel {

    private  FirebasePresenter presenter;
    private DatabaseReference dbRef;

    public void registerUser(final String email, String password, final String name, final int yearStarted, final int yearFinished,
                             FirebaseAuth mAuth){
        Log.i("TAG", "trying register");
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(((RegisterPresenter)presenter).getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            dbRef.child("users").child(FirebaseAuth.getInstance()
                                    .getCurrentUser().getUid()).child("email").setValue(email);
                            dbRef.child("users").child(FirebaseAuth.getInstance()
                                    .getCurrentUser().getUid()).child("name").setValue(name);
                            dbRef.child("users").child(FirebaseAuth.getInstance()
                                    .getCurrentUser().getUid()).child("photo").setValue("");
                            dbRef.child("users").child(FirebaseAuth.getInstance()
                                    .getCurrentUser().getUid()).child("yearOfStudy").setValue(yearStarted);
                            dbRef.child("users").child(FirebaseAuth.getInstance()
                                    .getCurrentUser().getUid()).child("yearOfGraduation").setValue(yearFinished);
                            dbRef.child("users").child(FirebaseAuth.getInstance()
                                    .getCurrentUser().getUid()).child("reviews").setValue("[]");
                            dbRef.child("users").child(FirebaseAuth.getInstance()
                                    .getCurrentUser().getUid()).child("registerDate").setValue("");
                            ((RegisterPresenter)presenter).onUserRegistered();
                        } else {
                            ((RegisterPresenter)presenter).onRegisterFailed(task.getException().getMessage());
                        }
                    }
                });
    }

    public void setPresenter(FirebasePresenter presenter){
        this.presenter = presenter;
    }

    public FirebaseModel() {
        dbRef = FirebaseDatabase.getInstance().getReference();
    }

    public void signInUser(String email, final String password, FirebaseAuth mAuth) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(((StartPresenter)presenter).getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            ((StartPresenter)presenter).onUserSigned();
                        } else {
                            // If sign in fails, display a message to the user.
                            ((StartPresenter)presenter).onSignFailed(task.getException().getMessage());
                        }
                    }
                });
    }

    public void loadTeacherByDepartment(final int department){
        Log.i("TAG", "model load " + department + " " + department);
        final List<Teacher> teachers = new ArrayList<>();
        dbRef.child("teachers").child(department + "").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<String> courses = new ArrayList<>();
                for(DataSnapshot child : dataSnapshot.getChildren()) {
                    courses.clear();
                    String about = child.child("about").getValue().toString();
                    String img = child.child("img").getValue().toString();
                    String name = child.child("name").getValue().toString();
                    String email = child.child("email").getValue().toString();
                    for(DataSnapshot coursesChild : dataSnapshot.child("courses").getChildren()) {
                        courses.add(coursesChild.getValue().toString());
                    }
                    teachers.add(new Teacher(about, courses, email, img, name, department));
                }
                ((DepartmentInfoPresenter)presenter).onTeachersLoaded(teachers);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void loadFaculties() {
        final List<Faculty> faculties = new ArrayList<>();
        dbRef.child("faculties").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot child : dataSnapshot.getChildren()) {
                    String code = child.getKey();
                    String about = child.child("about").getValue().toString();
                    String img = child.child("img").getValue().toString();
                    String name = child.child("name").getValue().toString();
                    String nameShort = child.child("nameShort").getValue().toString();
                    faculties.add(new Faculty(about, name, img, nameShort, code, new ArrayList<Department>()));
                }
                ((MainPresenter)presenter).onFacultiesLoaded(faculties);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void loadTeachersSmall() {
        final List<Teacher> teachers = new ArrayList<>();
        final List<String> courcesIDs = new ArrayList<>();
        dbRef.child("teachers").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Random random = new Random();
                int mDepartment = random.nextInt((int) dataSnapshot.getChildrenCount());
                Iterator itr = dataSnapshot.getChildren().iterator();

                for(int i = 0; i < mDepartment; i++) {
                    itr.next();
                }
                DataSnapshot departmentSnapshot = (DataSnapshot) itr.next();
                int departmentID = Integer.parseInt(departmentSnapshot.getKey());

                for(DataSnapshot child : departmentSnapshot.getChildren()) {
                    String about = child.child("about").getValue().toString();
                    String img = child.child("img").getValue().toString();
                    String name = child.child("name").getValue().toString();
                    String email = child.child("email").getValue().toString();

                    courcesIDs.clear();
                    for(DataSnapshot courcesChild : departmentSnapshot.child("cources").getChildren()) {
                        courcesIDs.add(courcesChild.getValue().toString());
                    }
                    teachers.add(new Teacher(about, courcesIDs, email, img, name, departmentID));
                    if(teachers.size()>4)
                        break;
                }


                ((MainPresenter)presenter).onTeachersLoaded(teachers);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ((MainPresenter)presenter).onTeachersLoaded(teachers);
    }

    public void loadCourse() {
        dbRef.child("courses").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Random random = new Random();
                Log.i("TAG", "" + dataSnapshot.getChildrenCount());
                int mDepartment = random.nextInt((int) dataSnapshot.getChildrenCount());
                Iterator itr = dataSnapshot.getChildren().iterator();

                for(int i = 0; i < mDepartment; i++) {
                    itr.next();
                }
                DataSnapshot departmentSnapshot = (DataSnapshot) itr.next();

                int mCourse = random.nextInt((int) departmentSnapshot.getChildrenCount());
                itr = departmentSnapshot.getChildren().iterator();

                for(int i = 0; i < mCourse; i++) {
                    itr.next();
                }
                DataSnapshot courseSnapshot = (DataSnapshot) itr.next();
                Course course = courseSnapshot.getValue(Course.class);
                ((MainPresenter)presenter).onCourseLoaded(course);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void loadFacultyData(String facultyCode) {
        dbRef.child("faculties").child(facultyCode).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String about = dataSnapshot.child("about").getValue().toString();
                String image = dataSnapshot.child("img").getValue().toString();
                String name = dataSnapshot.child("name").getValue().toString();
                String departmentsCount = String.valueOf(dataSnapshot.child("departments").getChildrenCount());
                List<Department> departments = new ArrayList<>();
                for(DataSnapshot child : dataSnapshot.child("departments").getChildren()){
                    departments.add(new Department(Integer.parseInt(child.getKey()),
                            child.child("name").getValue().toString()));
                }
                ((FacultyInfoPresenter)presenter).onDataLoaded(departments, departmentsCount, "", about, name, image);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
