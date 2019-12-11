package com.example.shape_it_final;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This is the activity that plays the shapes
 *
 *
 */
public class ShapeActivity extends AppCompatActivity {

    //for logging and debugging
    private String TAG = "SHAPEIT ShapeActivity";

    //Global declarations to manipulate textView and imageButton
    private TextView shapeName;
    private ImageButton shapeButton;

    //Global declarations to manipulate gameItem and shapeFactory
    private GameItem gameItem;
    private ShapeFactory shapeFactory;

    //Holds the amount of time that passes between clicks
    private long clickTime = 0;

    //This begins our activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //for logging and debugging
        Log.i(TAG, "Started ShapeActivity");

        //Setting up our activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape);

        //initiates and sets our button and text
        shapeButton = findViewById(R.id.imageButton);
        shapeName = findViewById(R.id.textView);

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

                //if not enough time has passed, then return out of the click
                if (SystemClock.elapsedRealtime() - clickTime < 3000){
                    return;
                }
                //Just adds up the passed time each click
                clickTime = SystemClock.elapsedRealtime();

                //shows the name above the shape image and starts the sound file
                gameItem.showsName();
                gameItem.saysName(getApplicationContext());

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

