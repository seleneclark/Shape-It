package com.example.shape_it_final;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Pentagon Class
 *
 * A Pentagon is a type of GameItem that will appear in GameActivity to
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
public class Pentagon implements GameItem {

    private String TAG = "SHAPEIT Pentagon";
    private ImageButton pentagonButton;
    private TextView pentagonName;

    /**
     * Pentagon Constructor
     *
     * Assigns the parameters to the method variables.
     * @param shapeButton - reference to the button on GameActivity
     * @param shapeName - reference to the TextView on GameActivity
     */
    Pentagon(ImageButton shapeButton, TextView shapeName) {
        Log.i(TAG, "Started Square class");
        pentagonButton = shapeButton;
        pentagonName = shapeName;
    }

    @Override
    public void draw() {
        pentagonButton.setImageResource(R.drawable.pentagon);
        Log.i(TAG, "Drew a Pentagon");
    }

    @Override
    public void showsName() {
        pentagonName.setText("Pentagon");
        Log.i(TAG, "Shows the Pentagon Name");
    }

    @Override
    public void saysName(Context context) {
        //this needs changed to Pentagon audio
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.pentagon);
        mediaPlayer.start();
        Log.i(TAG, "Played the sound of the name of the Pentagon");
    }

    @Override
    public void clearName() {
        pentagonName.setText("");
        Log.i(TAG, "Cleared the Pentagon Name");
    }
}
