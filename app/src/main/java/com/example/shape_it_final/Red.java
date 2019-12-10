package com.example.shape_it_final;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Red Class
 *
 * A Red is a type of GameItem that will appear in ColorActivity to
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
public class Red implements GameItem {

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

    @Override
    public void draw() {
        redButton.setImageResource(R.drawable.red);
        Log.i(TAG, "Drew a red color");
    }

    @Override
    public void showsName() {
        redName.setText("Red");
        Log.i(TAG, "Shows the Red Name");
    }

    @Override
    public void saysName(Context context) {
        //this needs changed to Red audio
        final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.red);
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

        Log.i(TAG, "Played the sound of the name of the Red");
    }

    @Override
    public void clearName() {
        redName.setText("");
        Log.i(TAG, "Cleared the Red Name");
    }
}
