package com.example.shape_it_final;

import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

//had to extend gameActivity in order for the context of mediaplayer, not sure if good idea
public class Triangle implements GameItem {

    Triangle(ImageButton shapeButton) {
        
        shapeButton.setImageResource(R.drawable.triangle);
        shapeName = findViewById(R.id.textView);
        shapeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            shapeName.setText(triangleWord);
            android.media.MediaPlayer mediaPlayer= android.media.MediaPlayer.create(GameActivity.this,R.raw.triangle_audio);
            mediaPlayer.start();
            Handler h = new Handler();
            h.postDelayed(r, 3000); // <-- the "3000" is the delay time in milliseconds.
            }
        });

    }



    //passes the imagebutton to be updated from GameActivity
    //this seems to crash the program...
    @Override
    public void draw(ImageButton b) {
        b.setImageResource(R.drawable.triangle);

    }

    //passes the textview to be updated from Gameactivity
    //this seems to crash the program...
    @Override
    public void showsName(TextView v) {

        v.setText("Triangle");

    }

    //plays the sound of a given shape, finding the context was difficult, not sure if right
    @Override
    public void saysName() {

        //android.media.MediaPlayer mediaPlayer = android.media.MediaPlayer.create(Triangle.this,R.raw.triangle_audio);
        //mediaPlayer.start();
/**
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(Triangle.this, Uri.parse("android.resource://"));
        } catch (IOException e) {
            e.printStackTrace();
        }
**/
    }
}
