package com.example.shape_it_final;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;
/**
 * Circle Class
 *
 * A Circle is a type of GameItem that will appear in GameActivity to
 * be touched where it will then show its name and say its name
 *
 * Implements the GameItem Interface
 *
 *Methods:
 *  draw() - Draw will draw the GameItem on the screen
 *  showsName() - will make the name of the GameItem appear
 *  saysName() - will say the name of the GameItem
 *  clearName() - will clear the name from the screen
 */
public class Circle implements GameItem {

    private String TAG = "SHAPEIT Circle";
    private ImageButton circleButton;
    private TextView circleName;

    /**
     * Circle Constructor
     *
     * Assigns the parameters to the method variables.
     * @param shapeButton - reference to the button on GameActivity
     * @param shapeName - reference to the TextView on GameActivity
     */

    Circle(ImageButton shapeButton, TextView shapeName) {
        Log.i(TAG, "Started Circle class");
        circleButton = shapeButton;
        circleName = shapeName;
    }

    @Override
    public void draw() {
        circleButton.setImageResource(R.drawable.circle);
        Log.i(TAG, "Drew a Circle");
    }

    @Override
    public void showsName() {

        circleName.setText("Circle");
        Log.i(TAG, "Shows the Circle Name");

    }

    @Override
    public void saysName(Context context) {
        //this needs changed to circle audio
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.circle);
        mediaPlayer.start();
        Log.i(TAG, "Played the sound of the name of the circle");

    }

    @Override
    public void clearName() {

        circleName.setText("");
        Log.i(TAG, "Cleared the Circle Name");

    }
}
