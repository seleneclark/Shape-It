package com.example.shape_it_final;

import android.util.Log;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import static org.junit.Assert.*;
@RunWith(AndroidJUnit4.class)

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> _ActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    private MainActivity _Activity = null;

    @Before
    public void setUp() throws Exception {
        try {
            _Activity = _ActivityTestRule.getActivity();
        } catch (Exception e) {
            Log.e("SHAPEIT", "Exception thrown in set up test");
        }
    }

    @Test
    public void testLaunch() {
        View view = _Activity.findViewById(R.id.welcomeText);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
        try {
        _Activity = null;
        } catch (Exception e) {
            Log.e("SHAPEIT", "Exception thrown in teardown test");
        }
    }

}