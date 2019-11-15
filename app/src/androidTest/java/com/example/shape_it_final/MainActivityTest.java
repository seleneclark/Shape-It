package com.example.shape_it_final;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import static androidx.core.content.ContextCompat.startActivity;
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
    public ActivityTestRule<MainActivity> _ActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    private MainActivity _Activity = null;

    @Before
    public void setUp() {
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

    @Test
    public void testStartButton() {
        assertNotNull(_Activity.findViewById(R.id.startButton));
    }
    @Test
    public void testLaunchOfGameActivity() {
        Intent startGameActivity = _Activity.getIntent();
        assertNotNull("Intent is null", startGameActivity);
    }

    @After
    public void tearDown() {
        try {
        _Activity = null;
        } catch (Exception e) {
            Log.e("SHAPEIT", "Exception thrown in teardown test");
        }
    }



}