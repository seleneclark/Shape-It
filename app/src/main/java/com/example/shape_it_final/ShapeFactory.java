package com.example.shape_it_final;

import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class ShapeFactory {

    //this is called by GameActivity to send back the correct shape depending on the ID
    public GameItem getShape(ImageButton shapeButton, TextView shapeName, int currentShapeID) {
        if (currentShapeID == 0) { //<-- 0 returns triangle shape
            return new Triangle(shapeButton, shapeName);
        }
        else if (currentShapeID == 1) { //<-- 1 returns circle shape
            return new Circle(shapeButton, shapeName);
        }
        /*
         else if(currentShapeID == 2){
         return new Rectangle();
         }
         else if(currentShapeID == 3){
         return new Square();
         }
        */
        return null;

    }

    /*Trying a random number generator to go through the different shapes.
    I just overloaded the getShape from above.
     */

    public GameItem getShape(ImageButton shapeButton, TextView shapeName) {
        int numberGameItems = 8; //right now its Circle, Triangle, Square
        Random random = new Random();
        int randomNumber = random.nextInt(numberGameItems);

        switch (randomNumber) {
            case 0:
                return new Triangle(shapeButton, shapeName);
            case 1:
                return new Circle(shapeButton, shapeName);
            case 2:
                return new Square(shapeButton, shapeName);
            case 3:
                return new Rectangle(shapeButton, shapeName);
            case 4:
                return new Star(shapeButton, shapeName);
            case 5:
                return new Oval(shapeButton, shapeName);
            case 6:
                return new Heart(shapeButton, shapeName);
            case 7:
                return new Pentagon(shapeButton, shapeName);
                default:
                    return null;
        }


    }

}






