package com.example.shape_it_final;

import android.widget.ImageButton;
import android.widget.TextView;

import androidx.constraintlayout.solver.widgets.Rectangle;

public class ShapeFactory {

    //this is called by GameActivity to send back the correct shape depending on the ID
    public GameItem getShape(ImageButton shapeButton, TextView shapeName, int currentShapeID) {
        if (currentShapeID == 0) {
            return new Triangle(shapeButton, shapeName);
        }
        return null;
    }

/**
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
 **/
}






