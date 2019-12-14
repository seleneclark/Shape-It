package com.example.shape_it_final;

import android.util.Log;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

/**
 * Runs tests on ColorActivity
 */
public class ColorActivityTest {

    @Rule
    public ActivityTestRule<ShapeActivity> colorActivityTestRule = new ActivityTestRule<>(ShapeActivity.class);
    private ShapeActivity colorActivityTest = null;

    @Before
    public void setUp() throws Exception {

        try {
            colorActivityTest = colorActivityTestRule.getActivity();
        } catch (Exception e) {
            Log.e("SHAPEIT", "Exception thrown in set up test");
        }
    }
    @Test
    public void test_isShapeActivityInView() {
        onView(withId(R.id.color)).check(matches(isDisplayed()));
    }
    @Test
    public void test_visibility_ShapeItemOnTheScreen() {
        onView(withId(R.id.colorButton)).check(matches(isDisplayed()));
    }
    @After
    public void tearDown() throws Exception {
        try {
            colorActivityTest = null;
        } catch (Exception e) {
            Log.e("SHAPEIT", "Exception thrown in teardown test of ShapeActivity");
        }

    }
}