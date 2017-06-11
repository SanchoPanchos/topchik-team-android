package com.sasha.reviews;

import com.sasha.reviews.model.Teacher;

import org.junit.Assert;
import org.junit.Test;

public class UnitTest {

    @Test
    public void shortNameFirstTest() throws Exception {
        Teacher teacher = new Teacher();
        Assert.assertEquals("NOT EQUALS!!!", teacher.getShortName("Oleksandr Yurievich Zakrevskyi"), "A.A.A");
    }

    @Test
    public void shortNameSecondTest() throws Exception {
        Teacher teacher = new Teacher();
        Assert.assertEquals("NOT EQUALS!!!", teacher.getShortName("Oleksandr Yurievich Zakrevskyi"), "Oleksandr Y.Z.");
    }
}