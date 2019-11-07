package com.example.shape_it_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class GameActivity extends AppCompatActivity {

    //GameItem commented out until it is added
    //GameItem gameItem = new GameItem();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);



    }

    //attached to imageButton in activity_game.xml and is called if touched
    public void buttonTouched() {

    }
}

