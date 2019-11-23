package com.example.shape_it_final;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

public class Triangle implements GameItem {

    private String TAG = "SHAPEIT Triangle";
    private ImageButton triangleButton;
    private TextView triangleName;

    Triangle(ImageButton shapeButton, TextView shapeName) {
        Log.i(TAG, "Started Triangle class");
        triangleButton = shapeButton;
        triangleName = shapeName;
    }

    @Override
    public void draw() {
        triangleButton.setImageResource(R.drawable.triangle2);
        Log.i(TAG, "Drew a Triangle");
    }

    @Override
    public void showsName() {
        triangleName.setText("Triangle");
        //triangleButton.setImageResource(R.drawable.triangle_name);
        Log.i(TAG, "Shows the Triangle Name");
    }

    //plays the sound of a given shape, finding the context was difficult, not sure if right
    @Override
    public void saysName(Context context) {

        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.triangle_audio);
        mediaPlayer.start();
        Log.i(TAG, "Played the sound of the name of the triangle");
    }

    @Override
    public void clearName() {

        triangleName.setText("");
        Log.i(TAG, "Cleared the Triangle Name");

    }
}
