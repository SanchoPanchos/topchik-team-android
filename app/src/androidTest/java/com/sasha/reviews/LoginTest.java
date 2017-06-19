package com.sasha.reviews;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.sasha.reviews.activities.Start;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class LoginTest {

    @Rule
    public ActivityTestRule<Start> mActivityRule = new ActivityTestRule<>(
            Start.class);

    @Test
    public void testLogin() throws Exception {
        onView(withId(R.id.start_email)).perform(typeText("sasha@a.com"));
        onView(withId(R.id.start_password)).perform(typeText("123456789"));
        onView(withId(R.id.start_login)).perform(click());
    }

    @Test
    public void testMoreLogin() throws Exception {
        onView(withId(R.id.start_email)).perform(typeText("sasha@a.com"));
        onView(withId(R.id.start_password)).perform(typeText("12345678"));
        onView(withId(R.id.start_login)).perform(click());
    }

}
