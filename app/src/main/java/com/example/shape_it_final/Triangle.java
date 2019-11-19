package com.example.shape_it_final;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

//had to extend gameActivity in order for the context of mediaplayer, not sure if good idea
public class Triangle implements GameItem {



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
