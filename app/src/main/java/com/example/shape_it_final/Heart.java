package com.example.shape_it_final;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;
/**
 * Heart Class
 *
 * A Heart is a type of GameItem that will appear in GameActivity to
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
public class Heart implements GameItem {

    private String TAG = "SHAPEIT Heart";
    private ImageButton heartButton;
    private TextView heartName;

    /**
     * Heart Constructor
     *
     * Assigns the parameters to the method variables.
     * @param shapeButton - reference to the button on GameActivity
     * @param shapeName - reference to the TextView on GameActivity
     */
    Heart(ImageButton shapeButton, TextView shapeName) {
        Log.i(TAG, "Started Heart class");
        heartButton = shapeButton;
        heartName = shapeName;
    }

    @Override
    public void draw() {
        //this needs changed to Heart image
        heartButton.setImageResource(R.drawable.triangle2);
        Log.i(TAG, "Drew a Heart");
    }

    @Override
    public void showsName() {
        heartName.setText("Heart");
        //heartButton.setImageResource(R.drawable.triangle_name);
        Log.i(TAG, "Shows the Heart Name");
    }

    //plays the sound of a given shape, finding the context was difficult, not sure if right
    @Override
    public void saysName(Context context) {
        //this needs changed to Star audio
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.triangle_audio);
        mediaPlayer.start();
        Log.i(TAG, "Played the sound of the name of the heart");
    }

    @Override
    public void clearName() {

        heartName.setText("");
        Log.i(TAG, "Cleared the Heart Name");

    }
}
