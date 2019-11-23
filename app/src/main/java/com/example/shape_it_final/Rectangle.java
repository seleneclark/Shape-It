package com.example.shape_it_final;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;
/**
 * Rectangle Class
 *
 * A Rectangle is a type of GameItem that will appear in GameActivity to
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
public class Rectangle implements GameItem {

    private String TAG = "SHAPEIT Rectangle";
    private ImageButton rectangleButton;
    private TextView rectangleName;

    /**
     * Rectangle Constructor
     *
     * Assigns the parameters to the method variables.
     * @param shapeButton - reference to the button on GameActivity
     * @param shapeName - reference to the TextView on GameActivity
     */
    Rectangle(ImageButton shapeButton, TextView shapeName) {
        Log.i(TAG, "Started Rectangle class");
        rectangleButton = shapeButton;
        rectangleName = shapeName;
    }

    @Override
    public void draw() {
        rectangleButton.setImageResource(R.drawable.rectangle);
        Log.i(TAG, "Drew a Rectangle");
    }

    @Override
    public void showsName() {
        rectangleName.setText("Rectangle");
        //rectangleButton.setImageResource(R.drawable.triangle_name);
        Log.i(TAG, "Shows the Rectangle Name");
    }

    //plays the sound of a given shape, finding the context was difficult, not sure if right
    @Override
    public void saysName(Context context) {
        //this needs changed to Rectangle audio
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.triangle_audio);
        mediaPlayer.start();
        Log.i(TAG, "Played the sound of the name of the rectangle");
    }

    @Override
    public void clearName() {

        rectangleName.setText("");
        Log.i(TAG, "Cleared the Rectangle Name");

    }
}