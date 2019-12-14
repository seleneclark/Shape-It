package com.example.shape_it_final;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Oval is a type of GameItem that will appear in ShapeActivity.
 *
 * When touched it will then show its name and say its name.  It
 * implements the GameItem Interface.  Its methods are: draw(),
 * showsName(), saysName(), and clearName().
 */
public class Oval implements GameItem {

    //class variables
    private String TAG = "SHAPEIT Oval";
    private ImageButton ovalButton;
    private TextView ovalName;

    /**
     * Oval Constructor
     *
     * Assigns the parameters to the method variables.
     * @param shapeButton - reference to the button on ShapeActivity
     * @param shapeName - reference to the TextView on ShapeActivity
     */
    Oval(ImageButton shapeButton, TextView shapeName) {
        Log.i(TAG, "Started Square class");
        ovalButton = shapeButton;
        ovalName = shapeName;
    }

    /**
     * draw()
     * sets button to image
     */
    @Override
    public void draw() {
        ovalButton.setImageResource(R.drawable.oval);
        Log.i(TAG, "Drew an Oval");
    }

    /**
     * showsName()
     * sets text to name of gameItem
     */
    @Override
    public void showsName() {
        ovalName.setText("Oval");
        Log.i(TAG, "Shows the Oval Name");
    }

    /**
     * saysName()
     * uses media player to play sound file
     */
    @Override
    public void saysName(Context context) {
        //this needs changed to Oval audio
        final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.oval);
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

        Log.i(TAG, "Played the sound of the name of the Oval");
    }

    /**
     * clearName()
     * reset text to an empty string for next gameItem
     */
    @Override
    public void clearName() {
        ovalName.setText("");
        Log.i(TAG, "Cleared the Oval Name");
    }
}
