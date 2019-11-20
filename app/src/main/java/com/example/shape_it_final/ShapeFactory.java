package com.example.shape_it_final;

import android.widget.ImageButton;

public class ShapeFactory {
    ShapeFactory(int currentShapeID){
        if(currentShapeID == 0){
            ImageButton shapeButton = findViewById(R.id.imageButton);
            return new Triangle(shapeButton);
        }
        else if(currentShapeID == 1){
            return new Circle();
        }
        else if(currentShapeID == 2){
            return new Rectangle();

        }
        else if(currentShapeID == 3){
            return new Square();
        }

    }
}





}
