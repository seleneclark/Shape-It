package com.example.shape_it_final;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.jinatonic.confetti.CommonConfetti;

/**
 * This is the activity that controls the Color Game.
 *
 * A color appears on the screen. When the color
 * is touched, it says its name and the name of the color appears
 * on the screen.  In addition,  confetti rains from the top of
 * the screen in celebration.
 */
public class ColorActivity extends AppCompatActivity {
    //for logging and debugging
    private String TAG = "SHAPEIT ColorActivity";

    //Global declarations to manipulate textViewShape and imageButton
    private TextView colorName;
    private ImageButton colorButton;

    //Global declarations to manipulate gameItem and shapeFactory
    private GameItem gameItem;
    private ColorFactory colorFactory;

    //Holds the amount of time that passes between clicks
    private long clickTime = 0;

    /**
     * This method runs the Color Game
     *
     * The game functionality runs through this method.  A color is
     * created here and all the methods to draw, say the name of the
     * color, and show the name of the color are called.
     *
     * @param savedInstanceState The Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //just logging for debugging
        Log.i(TAG, "Started ColorActivity");

        //setting up our activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        //initiates and sets our button and text
        colorButton = findViewById(R.id.imageButtonColor);
        colorName = findViewById(R.id.textViewColor);

        //logging for debugging
        Log.i(TAG, "Instantiate a colorFactory");

        //initializing our colorFactory
        colorFactory = new ColorFactory();

        //Create our game item using our factory random generator method
        gameItem = colorFactory.getColor(colorButton, colorName);

        //logging for debugging
        Log.i(TAG, "Got a game item " + gameItem);

        //calling the draw function to show our first color
        gameItem.draw();

        //Playing the auditory instructions
        final MediaPlayer mediaPlayer = MediaPlayer.create(ColorActivity.this,R.raw.color_intro);
        mediaPlayer.start();



        //This listens for a click on our shape
        colorButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //this release is in case the user touches the button before the intro finishes
                //so sounds aren't playing over the top of one another
                mediaPlayer.release();

                //if not enough time has passed, then return out of the click
                if (SystemClock.elapsedRealtime() - clickTime < 3000){
                    return;
                }
                //Just adds up the passed time each click
                clickTime = SystemClock.elapsedRealtime();

                //shows the name above the color image and starts the sound file
                gameItem.showName();
                gameItem.sayName(getApplicationContext());

                //Confetti briefly rains from the top of the screen
                int[] confettiColors = new int[] { Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.WHITE };
                CommonConfetti.rainingConfetti((ViewGroup)findViewById(R.id.color).getParent(), confettiColors)
                        .oneShot();

                //begins a pause to allow for sound to play before updating color
                Runnable r = new Runnable() {
                    @Override
                    public void run(){

                        //After 3 seconds, our shape will update and we will move to the next
                        gameItem = colorFactory.getColor(colorButton, colorName);
                        if (gameItem != null) {
                            gameItem.clearName();  //clears text
                            gameItem.draw();       //draws next color
                        }
                    }
                };

                //handles the delay
                Handler h = new Handler();
                h.postDelayed(r, 3000); // <-- the "3000" is the delay time in milliseconds.
            }
        });
    }
}