package com.example.shape_it_final;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Pink Class
 *
 * A Pink is a type of GameItem that will appear in ColorActivity to
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
public class Pink implements GameItem {

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

    @Override
    public void draw() {
        pinkButton.setImageResource(R.drawable.pink);
        Log.i(TAG, "Drew a pink color");
    }

    @Override
    public void showsName() {
        pinkName.setText("Pink");
        Log.i(TAG, "Shows the Pink Name");
    }

    @Override
    public void saysName(Context context) {
        //this needs changed to Pink audio
        final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.pink);
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

        Log.i(TAG, "Played the sound of the name of the Pink");
    }

    @Override
    public void clearName() {
        pinkName.setText("");
        Log.i(TAG, "Cleared the Pink Name");
    }
}
