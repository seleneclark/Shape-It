package com.example.shape_it_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

public class GameActivity extends AppCompatActivity {

    //ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

/**
        constraintLayout = new ConstraintLayout(this);

        ImageView i = new ImageView(this);
        i.setImageResource(R.drawable.triangle);

        i.setAdjustViewBounds(true);
        i.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        constraintLayout.addView(i);
        setContentView(constraintLayout);

****/
/**
        Resources res = context.getResources();
        Drawable myImage = ResouresCompat.getDrawables(res, R.drawable.triangle, null);
**/
/**
        Drawable replacer = getResources().getDrawable(R.drawable.triangle);
        ((R.id.imageButton).setImageResources(replacer);
**/

        //sets the imageButton to our triangle file
        ImageButton simpleImageButton = findViewById(R.id.imageButton);
        simpleImageButton.setImageResource(R.drawable.triangle);

/**
        //simply formats our image to match the button size
        simpleImageButton.setAdjustViewBounds(true);
        simpleImageButton.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
**/
    }

    //attached to imageButton in activity_game.xml and is called if touched
    public void buttonTouched() {

        GameItem gameItem = new GameItem() {
            @Override
            public void draw() {

            }

            @Override
            public void showsName() {

            }

            @Override
            public void saysName() {

            }
        };

    }
}

