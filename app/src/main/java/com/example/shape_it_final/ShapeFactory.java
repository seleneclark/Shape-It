package com.example.shape_it_final;

import android.widget.ImageButton;
import android.widget.TextView;

public class ShapeFactory {

    //this is called by GameActivity to send back the correct shape depending on the ID
    public GameItem getShape(ImageButton shapeButton, TextView shapeName, int currentShapeID) {
        if (currentShapeID == 0) { //<-- 0 returns triangle shape
            return new Triangle(shapeButton, shapeName);
        }
        else if (currentShapeID == 1) { //<-- 1 returns circle shape
            return new Circle(shapeButton, shapeName);
        }
        return null;
    }

/**
        else if(currentShapeID == 2){
            return new Rectangle();

        }
        else if(currentShapeID == 3){
            return new Square();
        }

    }
 **/
}






