package com.example.shape_it_final;


import android.media.MediaPlayer;
import android.graphics.Color;
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
 * This is the activity that controls the Shape Game.
 *
 * A shape appears on the screen.  When the shape is touched, it
 * says its name and the name of the shape appears on the screen.
 * In addition,  confetti rains from the top of the screen in celebration.
 */
public class ShapeActivity extends AppCompatActivity {

    //for logging and debugging
    private String TAG = "SHAPEIT ShapeActivity";

    //Global declarations to manipulate textViewShape and imageButton
    private TextView shapeName;
    private ImageButton shapeButton;

    //Global declarations to manipulate gameItem and shapeFactory
    private GameItem gameItem;
    private ShapeFactory shapeFactory;

    //Holds the amount of time that passes between clicks
    private long clickTime = 0;

    /**
     * This method runs the Shape Game
     *
     * The game functionality runs through this method.  A shape is
     * created here and all the methods to draw, say the name of the
     * shape, and show the name of the shape are called.
     *
     * @param savedInstanceState The Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //for logging and debugging
        Log.i(TAG, "Started ShapeActivity");

        //Setting up our activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape);

        //initiates and sets our button and text
        shapeButton = findViewById(R.id.imageButtonShape);
        shapeName = findViewById(R.id.textViewShape);

        //logging for debugging
        Log.i(TAG, "Instantiate a shapeFactory");

        //initializing our shapeFactory
        shapeFactory = new ShapeFactory();

        //Create our game item using our factory random generator method
        gameItem = shapeFactory.getShape(shapeButton, shapeName);

        //logging for debugging
        Log.i(TAG, "Got a game item " + gameItem);

        //calling the draw function to show our first shape
        gameItem.draw();

        //Playing the auditory instructions
        final MediaPlayer mediaPlayer = MediaPlayer.create(ShapeActivity.this,R.raw.shape_intro);
        mediaPlayer.start();



        //This listens for a click on our shape
        shapeButton.setOnClickListener(new View.OnClickListener() {
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

                //shows the name above the shape image and starts the sound file
                gameItem.showName();
                gameItem.sayName(getApplicationContext());

                //Confetti briefly rains from the top of the screen
                int[] confettiColors = new int[] { Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.WHITE };
                CommonConfetti.rainingConfetti((ViewGroup)findViewById(R.id.shape).getParent(), confettiColors)
                        .oneShot();

                //begins a pause to allow for sound to play before updating shape
                Runnable r = new Runnable() {
                    @Override
                    public void run(){

                        //After 3 seconds, our shape will update and we will move to the next
                        gameItem = shapeFactory.getShape(shapeButton, shapeName);
                        if (gameItem != null) {
                            gameItem.clearName();  //clears text
                            gameItem.draw();       //draws new shape
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

