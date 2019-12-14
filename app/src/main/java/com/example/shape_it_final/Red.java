package com.example.shape_it_final;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Red Color is a GameItem that will appear in Color Activity.
 *
 * When touched it will then show its name and say its name.  It
 * implements the GameItem Interface.  Its methods are: draw(),
 * showsName(), saysName(), and clearName().
 */
public class Red implements GameItem {

    //class variables
    private String TAG = "SHAPEIT Red";
    private ImageButton redButton;
    private TextView redName;

    /**
     * Red Constructor
     *
     * Assigns the parameters to the method variables.
     * @param colorButton - reference to the button on ColorActivity
     * @param colorName - reference to the TextView on ColorActivity
     */
    Red(ImageButton colorButton, TextView colorName) {
        Log.i(TAG, "Started Red class");
        redButton = colorButton;
        redName = colorName;
    }

    /**
     * draw()
     * sets button to image
     */
    @Override
    public void draw() {
        redButton.setImageResource(R.drawable.red);
        Log.i(TAG, "Drew a red color");
    }

    /**
     * showsName()
     * sets text to name of gameItem
     */
    @Override
    public void showsName() {
        redName.setText("Red");
        Log.i(TAG, "Shows the Red Name");
    }

    /**
     * saysName()
     * uses media player to play sound file
     */
    @Override
    public void saysName(Context context) {

        final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.red);
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

        Log.i(TAG, "Played the sound of the name of the Red");
    }

    /**
     * clearName()
     * reset text to an empty string for next gameItem
     */
    @Override
    public void clearName() {
        redName.setText("");
        Log.i(TAG, "Cleared the Red Name");
    }
}
