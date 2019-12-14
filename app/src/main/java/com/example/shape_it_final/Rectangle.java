package com.example.shape_it_final;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;
/**
 * Rectangle is a type of GameItem that will appear in ShapeActivity.
 *
 * When touched it will then show its name and say its name.  It
 * implements the GameItem Interface.  Its methods are: draw(),
 * showsName(), saysName(), and clearName().
 */
public class Rectangle implements GameItem {

    //class variables
    private String TAG = "SHAPEIT Rectangle";
    private ImageButton rectangleButton;
    private TextView rectangleName;

    /**
     * Rectangle Constructor
     *
     * Assigns the parameters to the method variables.
     * @param shapeButton - reference to the button on ShapeActivity
     * @param shapeName - reference to the TextView on ShapeActivity
     */
    Rectangle(ImageButton shapeButton, TextView shapeName) {
        Log.i(TAG, "Started Rectangle class");
        rectangleButton = shapeButton;
        rectangleName = shapeName;
    }

    /**
     * draw()
     * sets button to image
     */
    @Override
    public void draw() {
        rectangleButton.setImageResource(R.drawable.rectangle);
        Log.i(TAG, "Drew a Rectangle");
    }

    /**
     * showsName()
     * sets text to name of gameItem
     */
    @Override
    public void showsName() {
        rectangleName.setText("Rectangle");
        //rectangleButton.setImageResource(R.drawable.triangle_name);
        Log.i(TAG, "Shows the Rectangle Name");
    }

    /**
     * saysName()
     * uses media player to play sound file
     */
    @Override
    public void saysName(Context context) {

        final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.rectangle);
        mediaPlayer.start();

        //releases the media player after a delay
        Runnable r = new Runnable() {
            @Override
            public void run(){
                mediaPlayer.release();
            }
        };

        // helps handled the delay
        Handler h = new Handler();
        h.postDelayed(r, 3000); // <-- the "3000" is the delay time in milliseconds.

        Log.i(TAG, "Played the sound of the name of the rectangle");
    }

    /**
     * clearName()
     * reset text to an empty string for next gameItem
     */
    @Override
    public void clearName() {

        rectangleName.setText("");
        Log.i(TAG, "Cleared the Rectangle Name");

    }
}
