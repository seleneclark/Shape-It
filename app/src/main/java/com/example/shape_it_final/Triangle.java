package com.example.shape_it_final;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Triangle Class
 *
 * A Triangle is a type of GameItem that will appear in ShapeActivity to
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
public class Triangle implements GameItem {

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

    @Override
    public void draw() {
        triangleButton.setImageResource(R.drawable.triangle);
        Log.i(TAG, "Drew a Triangle");
    }

    @Override
    public void showsName() {
        triangleName.setText("Triangle");
        Log.i(TAG, "Shows the Triangle Name");
    }

    @Override
    public void saysName(Context context) {

        final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.triangle);
        mediaPlayer.start();

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

    @Override
    public void clearName() {

        triangleName.setText("");
        Log.i(TAG, "Cleared the Triangle Name");

    }
}
