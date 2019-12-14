package com.example.shape_it_final;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Pink Color is a GameItem that will appear in Color Activity.
 *
 * When touched it will then show its name and say its name.  It
 * implements the GameItem Interface.  Its methods are: draw(),
 * showName(), sayName(), and clearName().
 */
public class Pink implements GameItem {

    //class variables
    private String TAG = "SHAPEIT Pink";
    private ImageButton pinkButton;
    private TextView pinkName;

    /**
     * Pink Constructor
     *
     * Assigns the parameters to the method variables.
     * @param colorButton - reference to the button on ColorActivity
     * @param colorName - reference to the TextView on ColorActivity
     */
    Pink(ImageButton colorButton, TextView colorName) {
        Log.i(TAG, "Started Pink class");
        pinkButton = colorButton;
        pinkName = colorName;
    }

    /**
     * draw()
     * sets button to image
     */
    @Override
    public void draw() {
        pinkButton.setImageResource(R.drawable.pink);
        Log.i(TAG, "Drew a pink color");
    }

    /**
     * showName()
     * sets text to name of gameItem
     */
    @Override
    public void showName() {
        pinkName.setText("Pink");
        Log.i(TAG, "Shows the Pink Name");
    }

    /**
     * sayName()
     * uses media player to play sound file
     */
    @Override
    public void sayName(Context context) {

        final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.pink);
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

        Log.i(TAG, "Played the sound of the name of the Pink");
    }

    /**
     * clearName()
     * reset text to an empty string for next gameItem
     */
    @Override
    public void clearName() {
        pinkName.setText("");
        Log.i(TAG, "Cleared the Pink Name");
    }
}
