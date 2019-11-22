package com.example.shape_it_final;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;

public class GameActivity extends AppCompatActivity {

    //for logging and debugging
    String TAG = "SHAPEIT GameActivity";

    //Holds our current shape ID
    int currentShapeID = 0; // = 0 (For triangle)

    //Global declarations to manipulate textView and imageButton
    TextView shapeName;
    ImageButton shapeButton;

    //Global declarations to manipulate gameItem and shapeFactory
    GameItem gameItem;
    ShapeFactory shapeFactory = new ShapeFactory();


    //This begins our gameActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //just logging for debugging
        Log.i(TAG, "Started GameActivity");

        //getting started
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //saves the state of our game and shape by recording the ID of the current shape
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        currentShapeID = pref.getInt("currentShape", 0);

        //sets up the variables of the Button and the Name text field
        shapeButton = findViewById(R.id.imageButton);
        shapeName = findViewById(R.id.textView);

        //logging for debugging
        Log.i(TAG, "Instantiate a shapeFactory");
        //Create our game item using our factory method based upon shapeID
        gameItem = shapeFactory.getShape(shapeButton, shapeName, currentShapeID);
        Log.i(TAG, "Got a game item " + gameItem);
        gameItem.draw();

        //This listens for a click on our shape
        shapeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //shows the name above the shape image and starts the sound file
                //1
                gameItem.showsName();
                //2
                gameItem.saysName(getApplicationContext());

                //begins a pause to allow for sound to play before updating shape
                Runnable r = new Runnable() {
                    @Override
                    public void run(){
                        //4
                        //this counts our clicks on our button
                        if(currentShapeID <= 1)//<--- this number needs changed based on number of shapes
                            currentShapeID++;  //<-- increment up one shape
                        else if(currentShapeID >= 2)//<----this number also needs changed based on number of shapes
                            currentShapeID = 0; //<--- after we have gone through all the shapes, reset to triangle

                        //this will set our next shape and draw it
//                        gameItem = shapeFactory.getShape(shapeButton, shapeName, currentShapeID);

                        /*I'm just trying a different idea here.  Just send the shapeButton and shapeName
                        and I have a random number generator create choose the next shape. Downside is
                        that you might get the same shape in a row. Upside is that the game plays forever
                        and we don't need to keep track of the currentShapeID.
                        I just overloaded the getShape call so we can go back to it at any time.
                        - Selene
                         */
                        gameItem = shapeFactory.getShape(shapeButton, shapeName);
                        if (gameItem != null) {
                            gameItem.clearName();
                            gameItem.draw();
                        }
                    }
                };

                //helps handled the delay
                //3
                Handler h = new Handler();
                h.postDelayed(r, 3000); // <-- the "3000" is the delay time in milliseconds.
            }
        });


        //save this commented code in case we need to pull from it

//        //to update the textview and adds onclick event
//        shapeName = findViewById(R.id.textView);
//        shapeButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {

//                //simply sets textview to triangle for now
//                //1
//                shapeName.setText(triangleWord);
//                //this crashes for some reason
//                //triangle.showsName(shapeName);

                //2
//                android.media.MediaPlayer mediaPlayer= android.media.MediaPlayer.create(GameActivity.this,R.raw.triangle_audio);
//                mediaPlayer.start();
                //not working yet
                //triangle.saysName();

                //the idea here is to start a second thread to pause and then update our imageButton
                //might still need work... it works, just not sure if done properly
//                Runnable r = new Runnable() {
//                    @Override
//                    public void run(){
//                        //4
//                        shapeButton.setImageResource(R.drawable.triangle_name);
//                        shapeName.setText("");
//                    }
//                };

                //3
//                Handler h = new Handler();
//                h.postDelayed(r, 3000); // <-- the "3000" is the delay time in milliseconds.
//            }
//        });


    }

    //if our game is paused, this will save our ShapeID so we know our current state
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void saveCurrentShape() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("currentShape", currentShapeID);
        editor.commit();
    }


}

