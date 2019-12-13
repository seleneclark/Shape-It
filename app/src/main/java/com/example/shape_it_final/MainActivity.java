package com.example.shape_it_final;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This is the starting activity of the game.
 *
 * This Activity launches the game play of ShapeIt.  Here the user
 * may read the instructions and then choose to play the Shapes game
 * or the Colors Game by pressing the indicated buttons.
 */
public class MainActivity extends AppCompatActivity {

    //for debugging
    private static final String TAG = "SHAPEIT MainActivity";

    /**
     * This method starts our main activity
     *
     * @param savedInstanceState The Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method starts the Shape Activity Game.
     *
     * When the "Shapes" button is pressed in the MainActivity, this method is called
     * and the Shapes game is started.
     * @param view The View on the screen
     */
    public void startShape(View view) {
        //logging for debugging
        Log.i(TAG, "Entered startShape in MainActivity");

        //set up an intent to move to ShapeActivity
        Intent startShapeIntent = new Intent(this, ShapeActivity.class);
        startActivity(startShapeIntent);
    }

    /**
     *This method starts the Color Activity Game
     *
     * When the "Colors" button is pressed in the MainActivity, this method is called
     * and the Colors game is started.
     * @param view The View on the screen
     */
    public void startColor(View view) {
        //logging for debugging
        Log.i(TAG, "Entered startColor in MainActivity");

        //set up an intent to move to ColorActivity
        Intent startColorIntent = new Intent(this, ColorActivity.class);
        startActivity(startColorIntent);
    }
}
