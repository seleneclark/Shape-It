package com.example.shape_it_final;

import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

/**
 * Runs tests on ShapeActivity
 */
@RunWith(AndroidJUnit4.class)
public class ShapeActivityTest {

    @Rule
    public ActivityTestRule<ShapeActivity> shapeActivityTestRule = new ActivityTestRule<>(ShapeActivity.class);
    private ShapeActivity shapeActivityTest = null;

    @Before
    public void setUp() throws Exception {

        try {
            shapeActivityTest = shapeActivityTestRule.getActivity();
        } catch (Exception e) {
            Log.e("SHAPEIT", "Exception thrown in set up test");
        }
    }
    @Test
    public void test_isShapeActivityInView() {
        onView(withId(R.id.shape)).check(matches(isDisplayed()));
    }
    @Test
    public void test_visibility_ShapeItemOnTheScreen() {
        onView(withId(R.id.imageButton)).check(matches(isDisplayed()));
    }

    @After
    public void tearDown() throws Exception {
        try {
            shapeActivityTest = null;
        } catch (Exception e) {
            Log.e("SHAPEIT", "Exception thrown in teardown test of ShapeActivity");
        }
    }

}