package com.example.shape_it_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ColorActivity extends AppCompatActivity {
    //for logging and debugging
    String TAG = "SHAPEIT ColorActivity";

    //Global declarations to manipulate textView and imageButton
    TextView colorName;
    ImageButton colorButton;

    //Global declarations to manipulate gameItem and shapeFactory
    GameItem gameItem;
    ColorFactory colorFactory;

    private long clickTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //just logging for debugging
        Log.i(TAG, "Started ColorActivity");

        //getting started
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        //sets up the variables of the Button and the Name text field
        colorButton = findViewById(R.id.colorButton);
        colorName = findViewById(R.id.textView3);

        //logging for debugging
        Log.i(TAG, "Instantiate a colorFactory");

        //initializing our colorFactory
        colorFactory = new ColorFactory();

        //Create our game item using our factory random generator method
        gameItem = colorFactory.getColor(colorButton, colorName);

        //logging for debugging
        Log.i(TAG, "Got a game item " + gameItem);

        //calling the draw function to start our first shape
        gameItem.draw();

        //This listens for a click on our shape
        colorButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //
                if (SystemClock.elapsedRealtime() - clickTime < 3000){
                    return;
                }
                //
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
                        gameItem = colorFactory.getColor(colorButton, colorName);
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

}