package com.example.shape_it_final;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Star is a type of GameItem that will appear in ShapeActivity.
 *
 * When touched it will then show its name and say its name.  It
 * implements the GameItem Interface.  Its methods are: draw(),
 * showName(), sayName(), and clearName().
 */
public class Star implements GameItem {

    //class variables
    private String TAG = "SHAPEIT Star";
    private ImageButton starButton;
    private TextView starName;

    /**
     * Star Constructor
     *
     * Assigns the parameters to the method variables.
     * @param shapeButton - reference to the button on ShapeActivity
     * @param shapeName - reference to the TextView on ShapeActivity
     */
    Star(ImageButton shapeButton, TextView shapeName) {
        Log.i(TAG, "Started Star class");
        starButton = shapeButton;
        starName = shapeName;
    }

    /**
     * draw()
     * sets button to image
     */
    @Override
    public void draw() {
        starButton.setImageResource(R.drawable.star);
        Log.i(TAG, "Drew a Square");
    }

    /**
     * showName()
     * sets text to name of gameItem
     */
    @Override
    public void showName() {
        starName.setText("Star");
        Log.i(TAG, "Shows the Star Name");
    }

    /**
     * sayName()
     * uses media player to play sound file
     */
    @Override
    public void sayName(Context context) {

        final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.star);
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

        Log.i(TAG, "Played the sound of the name of the Star");
    }

    /**
     * clearName()
     * reset text to an empty string for next gameItem
     */
    @Override
    public void clearName() {
        starName.setText("");
        Log.i(TAG, "Cleared the Star Name");
    }
}
