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
    }

    @Override
    public void showsName() {
        circleName.setText("Circle");
    }

    @Override
    public void saysName(Context context) {
        //this needs changed to circle audio
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.triangle_audio);
        mediaPlayer.start();
    }

    @Override
    public void clearName() {
        circleName.setText("");
    }
}
