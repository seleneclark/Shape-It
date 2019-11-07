package com.example.shape_it_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //starts the next activity
    public void startGame(View view) {

        //set up an intent to move to GameActivity
        Intent startGameIntent = new Intent(this, GameActivity.class);
        startActivity(startGameIntent);

    }

}
