package com.example.shape_it_final;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Triangle is a type of GameItem that will appear in ShapeActivity.
 *
 * When touched it will then show its name and say its name.  It
 * implements the GameItem Interface.  Its methods are: draw(),
 * showName(), sayName(), and clearName().
 */
public class Triangle implements GameItem {

    //class variables
    private String TAG = "SHAPEIT Triangle";
    private ImageButton triangleButton;
    private TextView triangleName;

    /**
     * Triangle Constructor
     *
     * Assigns the parameters to the method variables.
     * @param shapeButton - reference to the button on ShapeActivity
     * @param shapeName - reference to the TextView on ShapeActivity
     */
    Triangle(ImageButton shapeButton, TextView shapeName) {
        Log.i(TAG, "Started Triangle class");
        triangleButton = shapeButton;
        triangleName = shapeName;
    }

    /**
     * draw()
     * sets button to image
     */
    @Override
    public void draw() {
        triangleButton.setImageResource(R.drawable.triangle);
        Log.i(TAG, "Drew a Triangle");
    }

    /**
     * showName()
     * sets text to name of gameItem
     */
    @Override
    public void showName() {
        triangleName.setText("Triangle");
        Log.i(TAG, "Shows the Triangle Name");
    }

    /**
     * sayName()
     * uses media player to play sound file
     */
    @Override
    public void sayName(Context context) {

        final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.triangle);
        mediaPlayer.start();

        //releases the media player after a delay
        Runnable r = new Runnable() {
            @Override
            public void run(){
                mediaPlayer.release();
            }
        };

        //helps handled the delay
        Handler h = new Handler();
        h.postDelayed(r, 3000); // <-- the "3000" is the delay time in milliseconds.


        Log.i(TAG, "Played the sound of the name of the triangle");
    }

    /**
     * clearName()
     * reset text to an empty string for next gameItem
     */
    @Override
    public void clearName() {

        triangleName.setText("");
        Log.i(TAG, "Cleared the Triangle Name");

    }
}
