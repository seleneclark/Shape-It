package com.example.shape_it_final;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Yellow Color is a GameItem that will appear in Color Activity.
 *
 * When touched it will then show its name and say its name.  It
 * implements the GameItem Interface.  Its methods are: draw(),
 * showsName(), saysName(), and clearName().
 */
public class Yellow implements GameItem {

    //class variables
    private String TAG = "SHAPEIT Yellow";
    private ImageButton yellowButton;
    private TextView yellowName;

    /**
     * Yellow Constructor
     *
     * Assigns the parameters to the method variables.
     * @param colorButton - reference to the button on ColorActivity
     * @param colorName - reference to the TextView on ColorActivity
     */
    Yellow(ImageButton colorButton, TextView colorName) {
        Log.i(TAG, "Started Yellow class");
        yellowButton = colorButton;
        yellowName = colorName;
    }

    /**
     * draw()
     * sets button to image
     */
    @Override
    public void draw() {
        yellowButton.setImageResource(R.drawable.yellow);
        Log.i(TAG, "Drew a yellow color");
    }

    /**
     * showsName()
     * sets text to name of gameItem
     */
    @Override
    public void showsName() {
        yellowName.setText("Yellow");
        Log.i(TAG, "Shows the Yellow Name");
    }

    /**
     * saysName()
     * uses media player to play sound file
     */
    @Override
    public void saysName(Context context) {

        final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.yellow);
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

        Log.i(TAG, "Played the sound of the name of the Yellow");
    }

    /**
     * clearName()
     * reset text to an empty string for next gameItem
     */
    @Override
    public void clearName() {
        yellowName.setText("");
        Log.i(TAG, "Cleared the Yellow Name");
    }
}
