package com.example.shape_it_final;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Purple Color is a GameItem that will appear in Color Activity.
 *
 * When touched it will then show its name and say its name.  It
 * implements the GameItem Interface.  Its methods are: draw(),
 * showName(), sayName(), and clearName().
 */
public class Purple implements GameItem {

    //class variables
    private String TAG = "SHAPEIT Purple";
    private ImageButton purpleButton;
    private TextView purpleName;

    /**
     * Purple Constructor
     *
     * Assigns the parameters to the method variables.
     * @param colorButton - reference to the button on ColorActivity
     * @param colorName - reference to the TextView on ColorActivity
     */
    Purple(ImageButton colorButton, TextView colorName) {
        Log.i(TAG, "Started Purple class");
        purpleButton = colorButton;
        purpleName = colorName;
    }

    /**
     * draw()
     * sets button to image
     */
    @Override
    public void draw() {
        purpleButton.setImageResource(R.drawable.purple);
        Log.i(TAG, "Drew a purple color");
    }

    /**
     * showName()
     * sets text to name of gameItem
     */
    @Override
    public void showName() {
        purpleName.setText("Purple");
        Log.i(TAG, "Shows the Purple Name");
    }

    /**
     * sayName()
     * uses media player to play sound file
     */
    @Override
    public void sayName(Context context) {

        final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.purple);
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

        Log.i(TAG, "Played the sound of the name of the Purple");
    }

    /**
     * clearName()
     * reset text to an empty string for next gameItem
     */
    @Override
    public void clearName() {
        purpleName.setText("");
        Log.i(TAG, "Cleared the Purple Name");
    }
}
