package com.sasha.reviews;

import android.util.Log;

import com.sasha.reviews.model.FirebaseModel;
import com.sasha.reviews.model.Teacher;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class ExampleUnitTest {

    @Test
    public void shortNameTest() throws Exception {
        Teacher teacher = new Teacher();
        //Assert.assertTrue(teacher.getShortName("Oleksandr Zalrev Oleg").equals("AAA"));
        System.out.print(teacher.getShortName("Oleksandr Bobrov Dinya"));
    }
}