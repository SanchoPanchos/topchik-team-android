package com.sasha.reviews;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.sasha.reviews.activity.Register;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class RegisterTest {

    @Rule
    public ActivityTestRule<Register> mActivityRule = new ActivityTestRule<>(
            Register.class);

    @Test
    public void testRegister() throws Exception{
        onView(withId(R.id.register_name)).perform(typeText("Sasha"));
        onView(withId(R.id.register_email)).perform(typeText("Sasha@a.com"));
        onView(withId(R.id.register_password)).perform(typeText("Sashapass"));
        onView(withId(R.id.register_year_begin)).perform(typeText("2014"));
        onView(withId(R.id.register_year_end)).perform(typeText("2018"));
        onView(withId(R.id.register_register)).perform(click());
    }

    @Test
    public void testMoreRegister() throws Exception{
        onView(withId(R.id.register_name)).perform(typeText("Alex"));
        onView(withId(R.id.register_email)).perform(typeText("Alex@aaa.com"));
        onView(withId(R.id.register_password)).perform(typeText("AlexPass"));
        onView(withId(R.id.register_year_begin)).perform(typeText("2010"));
        onView(withId(R.id.register_year_end)).perform(typeText("2014"));
        onView(withId(R.id.register_register)).perform(click());
    }
}
