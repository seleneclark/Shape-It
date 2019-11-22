package com.example.shape_it_final;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

public class Circle implements GameItem {

    private String TAG = "SHAPEIT Circle";
    private ImageButton circleButton;
    private TextView circleName;

    Circle(ImageButton shapeButton, TextView shapeName) {
        Log.i(TAG, "Started Circle class");
        circleButton = shapeButton;
        circleName = shapeName;
    }

    @Override
    public void draw() {
        //this needs changed to circle image
        circleButton.setImageResource(R.drawable.triangle_name);
        Log.i(TAG, "Drew a Circle");
    }

    @Override
    public void showsName() {

        circleName.setText("Circle");
        Log.i(TAG, "Shows the Circle Name");

    }

    @Override
    public void saysName(Context context) {
        //this needs changed to circle audio
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.triangle_audio);
        mediaPlayer.start();
        Log.i(TAG, "Played the sound of the name of the circle");

    }

    @Override
    public void clearName() {

        circleName.setText("");
        Log.i(TAG, "Cleared the Circle Name");

    }
}
