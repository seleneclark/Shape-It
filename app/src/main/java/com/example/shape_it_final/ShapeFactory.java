package com.example.shape_it_final;

import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class ShapeFactory {

    //this holds a value to prevent the same shape from showing up twice in a row
    int previousNumber;

    //This function randomly generates a shape to send to ShapeActivity
    public GameItem getShape(ImageButton shapeButton, TextView shapeName) {
        int numberGameItems = 8;
        Random random = new Random();
        int randomNumber = random.nextInt(numberGameItems);

        while (randomNumber == previousNumber) {
            randomNumber = random.nextInt(numberGameItems);
        }

        switch (randomNumber) {
            case 0:
                previousNumber = 0;
                return new Triangle(shapeButton, shapeName);
            case 1:
                previousNumber = 1;
                return new Circle(shapeButton, shapeName);
            case 2:
                previousNumber = 2;
                return new Square(shapeButton, shapeName);
            case 3:
                previousNumber = 3;
                return new Rectangle(shapeButton, shapeName);
            case 4:
                previousNumber = 4;
                return new Star(shapeButton, shapeName);
            case 5:
                previousNumber = 5;
                return new Oval(shapeButton, shapeName);
            case 6:
                previousNumber = 6;
                return new Heart(shapeButton, shapeName);
            case 7:
                previousNumber = 7;
                return new Pentagon(shapeButton, shapeName);
                default:
                    return null;
        }
    }
}






