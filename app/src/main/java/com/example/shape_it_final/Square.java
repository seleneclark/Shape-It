package com.example.shape_it_final;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Square Class
 *
 * A Square is a type of GameItem that will appear in GameActivity to
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
public class Square implements GameItem {

    private String TAG = "SHAPEIT Square";
    private ImageButton squareButton;
    private TextView squareName;

    /**
     * Square Constructor
     *
     * Assigns the parameters to the method variables.
     * @param shapeButton - reference to the button on GameActivity
     * @param shapeName - reference to the TextView on GameActivity
     */
    Square(ImageButton shapeButton, TextView shapeName) {
        Log.i(TAG, "Started Square class");
        squareButton = shapeButton;
        squareName = shapeName;
    }

    @Override
    public void draw() {
        squareButton.setImageResource(R.drawable.square);
        Log.i(TAG, "Drew a Square");
    }

    @Override
    public void showsName() {
        squareName.setText("Square");
        Log.i(TAG, "Shows the Square Name");
    }

    @Override
    public void saysName(Context context) {
        //this needs changed to Square audio
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.triangle_audio);
        mediaPlayer.start();
        Log.i(TAG, "Played the sound of the name of the Square");
    }

    @Override
    public void clearName() {
        squareName.setText("");
        Log.i(TAG, "Cleared the Square Name");
    }
}
