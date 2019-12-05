package com.example.shape_it_final;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * This tests the MainActivity class.  There are 3 tests: testLaunch,
 * testStartButton, & testLaunchOfGameActivity.
 * A @Rule creates an activity and sets it up in setUp.
 *
 * testLaunch(): If the TextView with the welcome text
 * can be found (findViewById) then the test passes.
 *
 * testStartButton(): If the startButton can be found then the test passes.
 *
 * testLaunchOfGameActivity():  An intent is created and checked.
 */

@RunWith(AndroidJUnit4.class)

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);
    private MainActivity activity = null;

    @Before
    public void setUp() {
        try {
            activity = activityTestRule.getActivity();
        } catch (Exception e) {
            Log.e("SHAPEIT", "Exception thrown in set up test");
        }
    }

    @Test
    public void test_isActivityInView() {
        onView(withId(R.id.main)).check(matches(isDisplayed()));
    }
    @Test
    public void test_visibility_ShapesButton() {
        onView(withId(R.id.ShapesButton)).check(matches(isDisplayed()));
    }
    @Test
    public void test_visibility_ColorsButton() {
        //an alternate way to test "matches(isDisplayed)"
        onView(withId(R.id.ColorsButton)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }
    @Test
    public void test_isTitleTextDisplayed() {
        onView(withId(R.id.welcomeText)).check(matches(withText(R.string.welcomeMessage)));

    }




    @Test
    public void testLaunch() {
        View view = activity.findViewById(R.id.welcomeText);
        assertNotNull(view);
    }

    @Test
    public void testStartButton() {
        assertNotNull(activity.findViewById(R.id.ShapesButton));
    }

    @Test
    public void testLaunchOfGameActivity() {
        Intent startGameActivity = activity.getIntent();
        assertNotNull("Intent is null", startGameActivity);
    }

    @After
    public void tearDown() {
        try {
        activity = null;
        } catch (Exception e) {
            Log.e("SHAPEIT", "Exception thrown in teardown test");
        }
    }



}