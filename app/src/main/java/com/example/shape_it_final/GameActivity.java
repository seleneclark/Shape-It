package com.example.shape_it_final;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;

public class GameActivity extends AppCompatActivity {

    //Holds our current shape ID
    int currentShapeID; //=1 (For triangle)

    //not in use yet
    //just a starter shape to begin our game
    Shape currentShape = new Shape(currentShapeID); //needs to be turned into non default constructor

    //not in use yet
    //just goofing off to get stuff done
    String triangle = "Triangle";

    //Global declarations to manipulate textView and imageButton
    TextView shapeName;
    ImageButton shapeButton;



    //This begins our gameActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //saves the state of our game and shape by recording the ID of the current shape
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        currentShapeID = pref.getInt("currentShape", 0);

        //sets the imageButton to our triangle file
        shapeButton = findViewById(R.id.imageButton);
        shapeButton.setImageResource(R.drawable.triangle);

        //to update the textview and adds onclick event
        shapeName = findViewById(R.id.textView);
        shapeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //simply sets textview to triangle for now
                String triangle = "Triangle";
                shapeName.setText(triangle);

                //the idea here is to start a second thread to pause and then update our imageButton
                //might still need work... it works, just not sure if done properly
                Runnable r = new Runnable() {
                    @Override
                    public void run(){
                        shapeButton.setImageResource(R.drawable.triangle_name);
                        shapeName.setText("");
                    }
                };

                Handler h = new Handler();
                h.postDelayed(r, 3000); // <-- the "3000" is the delay time in milliseconds.
                android.media.MediaPlayer mediaPlayer= android.media.MediaPlayer.create(GameActivity.this,R.raw.triangle_audio);
                mediaPlayer.start();
            }

        });



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

