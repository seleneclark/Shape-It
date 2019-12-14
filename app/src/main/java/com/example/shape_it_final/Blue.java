package com.example.shape_it_final;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Blue Color is a GameItem that will appear in Color Activity.
 *
 * When touched it will then show its name and say its name.  It
 * implements the GameItem Interface.  Its methods are: draw(),
 * showName(), sayName(), and clearName().
 */
public class Blue implements GameItem {

    //class variables
    private String TAG = "SHAPEIT Blue";
    private ImageButton blueButton;
    private TextView blueName;

    /**
     * Blue Constructor
     *
     * Assigns the parameters to the method variables.
     * @param colorButton - reference to the button on ColorActivity
     * @param colorName - reference to the TextView on ColorActivity
     */
    Blue(ImageButton colorButton, TextView colorName) {
        Log.i(TAG, "Started Blue class");
        blueButton = colorButton;
        blueName = colorName;
    }

    /**
     * draw()
     * sets button to blue image
     */
    @Override
    public void draw() {
        blueButton.setImageResource(R.drawable.blue);
        Log.i(TAG, "Drew a blue color");
    }

    /**
     * showName()
     * sets text to name of gameItem
     */
    @Override
    public void showName() {
        blueName.setText("Blue");
        Log.i(TAG, "Shows the Blue Name");
    }

    /**
     * sayName()
     * uses media player to play sound file
     */
    @Override
    public void sayName(Context context) {
        //uses media player to start sound file
        final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.blue);
        mediaPlayer.start();

        //releases the media player after a delay
        Runnable r = new Runnable() {
            @Override
            public void run(){
                mediaPlayer.release();
            }
        };

        //handles the delay to allow sound to finish playing
        Handler h = new Handler();
        h.postDelayed(r, 3000); // <-- the "3000" is the delay time in milliseconds.

        //debugging
        Log.i(TAG, "Played the sound of the name of the Blue");
    }

    /**
     * clearName()
     * reset text to an empty string for next gameItem
     */
    @Override
    public void clearName() {
        blueName.setText("");
        Log.i(TAG, "Cleared the Blue Name");
    }
}
