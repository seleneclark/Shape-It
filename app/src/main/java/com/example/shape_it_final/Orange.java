package com.example.shape_it_final;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Orange Class
 *
 * An Orange is a type of GameItem that will appear in ColorActivity to
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
public class Orange implements GameItem {

    //class variables
    private String TAG = "SHAPEIT Orange";
    private ImageButton orangeButton;
    private TextView orangeName;

    /**
     * Orange Constructor
     *
     * Assigns the parameters to the method variables.
     * @param colorButton - reference to the button on ColorActivity
     * @param colorName - reference to the TextView on ColorActivity
     */
    Orange(ImageButton colorButton, TextView colorName) {
        Log.i(TAG, "Started Orange class");
        orangeButton = colorButton;
        orangeName = colorName;
    }

    /**
     * draw()
     * sets button to image
     */
    @Override
    public void draw() {
        orangeButton.setImageResource(R.drawable.orange);
        Log.i(TAG, "Drew an orange color");
    }

    /**
     * showsName()
     * sets text to name of gameItem
     */
    @Override
    public void showsName() {
        orangeName.setText("Orange");
        Log.i(TAG, "Shows the Orange Name");
    }

    /**
     * saysName()
     * uses media player to play sound file
     */
    @Override
    public void saysName(Context context) {
        //this needs changed to Orange audio
        final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.orange);
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

        Log.i(TAG, "Played the sound of the name of the Orange");
    }

    /**
     * clearName()
     * reset text to an empty string for next gameItem
     */
    @Override
    public void clearName() {
        orangeName.setText("");
        Log.i(TAG, "Cleared the Orange Name");
    }
}
