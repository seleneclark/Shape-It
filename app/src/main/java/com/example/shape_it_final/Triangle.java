package com.example.shape_it_final;

import android.content.Context;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class Triangle implements GameItem {

    private String TAG = "SHAPEIT Triangle";
    private ImageButton triangleButton;
    private TextView triangleName;

    Triangle(ImageButton shapeButton, TextView shapeName) {
        Log.i(TAG, "Started Triangle class");
        triangleButton = shapeButton;
        triangleName = shapeName;

//        shapeButton = findViewById(R.id.imageButton);
//        shapeName = findViewById(R.id.textView);
//        shapeButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
////            shapeName.setText(triangleWord);
//            android.media.MediaPlayer mediaPlayer= android.media.MediaPlayer.create(GameActivity.this,R.raw.triangle_audio);
//            mediaPlayer.start();
////            Handler h = new Handler();
////            h.postDelayed(r, 3000); // <-- the "3000" is the delay time in milliseconds.
//            }
//        });

    }

    @Override
    public void draw() {
        triangleButton.setImageResource(R.drawable.triangle);
        Log.i(TAG, "Drew a Triangle");
    }

    @Override
    public void showsName() {
        triangleName.setText("Triangle");
        triangleButton.setImageResource(R.drawable.triangle_name);
        Log.i(TAG, "Drew a Triangle with the name");
    }

    //plays the sound of a given shape, finding the context was difficult, not sure if right
    @Override
    public void saysName(Context context) {

        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.triangle_audio);
        mediaPlayer.start();
        Log.i(TAG, "Played the sound of the name of the triangle");
    }
}
