package com.example.shape_it_final;

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
    String TAG = "SHAPEIT GameActivity";

    //not in use yet
    //Holds our current shape ID
    int currentShapeID; //=1 (For triangle)


    //just a starter shape to begin our game
    //Shape currentShape = new Shape(currentShapeID); //needs to be turned into non default constructor
    Triangle triangle;

    //just goofing off to get
    String triangleWord = "Triangle";

    //Global declarations to manipulate textView and imageButton
    TextView shapeName;
    ImageButton shapeButton;

    //this is for testing data from an intent, not in use
    //Intent gameIntent = new Intent(this, GameActivity.class);


    //This begins our gameActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "Started GameActivity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //saves the state of our game and shape by recording the ID of the current shape
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        currentShapeID = pref.getInt("currentShape", 0);

        //sets the imageButton to our triangle file
        shapeButton = findViewById(R.id.imageButton);
        shapeName = findViewById(R.id.textView);
//        shapeButton.setImageResource(R.drawable.triangle);

        Log.i(TAG, "Instantiate a Triangle");
        triangle = new Triangle(shapeButton, shapeName);
        triangle.draw();
        shapeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                triangle.showsName();
                triangle.saysName();
            }
        });


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

    //attached to imageButton in activity_game.xml and is called if touched
    public void buttonTouched(View v) {

        //to update the textview
        //TextView textView = findViewById(R.id.textView);
        //textView.setText("Triangle");
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

