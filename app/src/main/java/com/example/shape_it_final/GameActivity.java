package com.example.shape_it_final;


import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class GameActivity extends AppCompatActivity {

    //for logging and debugging
    private String TAG = "SHAPEIT GameActivity";

    //Global declarations to manipulate textView and imageButton
    private TextView shapeName;
    private ImageButton shapeButton;

    //Global declarations to manipulate gameItem and shapeFactory
    private GameItem gameItem;
    private ShapeFactory shapeFactory;

    private long clickTime = 0;


    //This begins our gameActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //just logging for debugging
        Log.i(TAG, "Started GameActivity");

        //getting started
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //commented out because we are using random shapes and don't need to save state of shape
        //saves the state of our game and shape by recording the ID of the current shape
        /*SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        currentShapeID = pref.getInt("currentShape", 0);*/

        //sets up the variables of the Button and the Name text field
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

        //calling the draw function to start our first shape
        gameItem.draw();



        //This listens for a click on our shape
        shapeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //if enough time hasn't passed, then we return out of this click
                if (SystemClock.elapsedRealtime() - clickTime < 3000){ //<--- 3 second delay time
                    return;
                }
                //this just adds up the time with each click so the next click has accurate data
                clickTime = SystemClock.elapsedRealtime();

                //shows the name above the shape image and starts the sound file
                //1
                gameItem.showsName();
                //2
                gameItem.saysName(getApplicationContext());

                //begins a pause to allow for sound to play before updating shape
                Runnable r = new Runnable() {
                    @Override
                    public void run(){

                        //After 3 seconds, our shape will update and we will move to the next
                        //gameItem
                        //4
                        gameItem = shapeFactory.getShape(shapeButton, shapeName);
                        if (gameItem != null) {
                            gameItem.clearName();
                            gameItem.draw();
                        }
                    }
                };

                //3 helps handled the delay
                Handler h = new Handler();
                h.postDelayed(r, 3000); // <-- the "3000" is the delay time in milliseconds.
            }
        });
    }

    //commented out because we are using random shapes
    //if our game is paused, this will save our ShapeID so we know our current state
    /*@OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void saveCurrentShape() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("currentShape", currentShapeID);
        editor.commit();
    }*/


}

