package com.example.shape_it_final;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Oval Class
 *
 * A Oval is a type of GameItem that will appear in GameActivity to
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
public class Oval implements GameItem {

    private String TAG = "SHAPEIT Oval";
    private ImageButton ovalButton;
    private TextView ovalName;

    /**
     * Oval Constructor
     *
     * Assigns the parameters to the method variables.
     * @param shapeButton - reference to the button on GameActivity
     * @param shapeName - reference to the TextView on GameActivity
     */
    Oval(ImageButton shapeButton, TextView shapeName) {
        Log.i(TAG, "Started Square class");
        ovalButton = shapeButton;
        ovalName = shapeName;
    }

    @Override
    public void draw() {
        ovalButton.setImageResource(R.drawable.oval);
        Log.i(TAG, "Drew an Oval");
    }

    @Override
    public void showsName() {
        ovalName.setText("Oval");
        Log.i(TAG, "Shows the Oval Name");
    }

    @Override
    public void saysName(Context context) {
        //this needs changed to Oval audio
        final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.oval);
        mediaPlayer.start();

        Runnable r = new Runnable() {
            @Override
            public void run(){
                mediaPlayer.release();
            }
        };

        //3 helps handled the delay
        Handler h = new Handler();
        h.postDelayed(r, 3000); // <-- the "3000" is the delay time in milliseconds.

        Log.i(TAG, "Played the sound of the name of the Oval");
    }

    @Override
    public void clearName() {
        ovalName.setText("");
        Log.i(TAG, "Cleared the Oval Name");
    }
}
