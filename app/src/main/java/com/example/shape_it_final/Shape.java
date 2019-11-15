package com.example.shape_it_final;

import android.widget.ImageButton;
import android.widget.TextView;

public class Shape implements GameItem {

    public enum Shape implements GameItem {
        Triangle;
    }

    public enum Shape implements GameItem {
        Triangle {
            @Override
            public void draw() {
                shapeButton = findViewById(R.id.imageButton);
                shapeButton.setImageResource(R.drawable.triangle);
                }
            },


    @Override
    public void showsName() {

    }

    @Override
    public void saysName() {

    }
}