package com.example.shape_it_final;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Pentagon is a type of GameItem that will appear in ShapeActivity.
 *
 * When touched it will then show its name and say its name.  It
 * implements the GameItem Interface.  Its methods are: draw(),
 * showName(), sayName(), and clearName().
 */
public class Pentagon implements GameItem {

    //class variables
    private String TAG = "SHAPEIT Pentagon";
    private ImageButton pentagonButton;
    private TextView pentagonName;

    /**
     * Pentagon Constructor
     *
     * Assigns the parameters to the method variables.
     * @param shapeButton - reference to the button on ShapeActivity
     * @param shapeName - reference to the TextView on ShapeActivity
     */
    Pentagon(ImageButton shapeButton, TextView shapeName) {
        Log.i(TAG, "Started Pentagon class");
        pentagonButton = shapeButton;
        pentagonName = shapeName;
    }

    /**
     * draw()
     * sets button to image
     */
    @Override
    public void draw() {
        pentagonButton.setImageResource(R.drawable.pentagon);
        Log.i(TAG, "Drew a Pentagon");
    }

    /**
     * showName()
     * sets text to name of gameItem
     */
    @Override
    public void showName() {
        pentagonName.setText("Pentagon");
        Log.i(TAG, "Shows the Pentagon Name");
    }

    /**
     * sayName()
     * uses media player to play sound file
     */
    @Override
    public void sayName(Context context) {
        //this needs changed to Pentagon audio
        final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.pentagon);
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

        Log.i(TAG, "Played the sound of the name of the Pentagon");
    }

    /**
     * clearName()
     * reset text to an empty string for next gameItem
     */
    @Override
    public void clearName() {
        pentagonName.setText("");
        Log.i(TAG, "Cleared the Pentagon Name");
    }
}
