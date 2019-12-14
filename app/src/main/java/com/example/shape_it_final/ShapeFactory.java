package com.example.shape_it_final;

import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

/**
 * This is a factory that creates the shapes for the Shape Game.
 *
 * This factory will randomly create a shape when it is called.  It can can create a
 * Triangle, Circle, Square, Rectangle, Star, Oval, Heart, or Pentagon.
 */
public class ShapeFactory {

    //this holds a value to prevent the same shape from showing up twice in a row
    int previousNumber;

    /**
     * This method randomly generates a shape to send to ShapeActivity.
     *
     * This factory will randomly create a shape when it is called.  It can can create a
     * Triangle, Circle, Square, Rectangle, Star, Oval, Heart, or Pentagon.
     *
     * @param shapeButton The button where the shape images appear
     * @param shapeName The TextView where the name of the color appears
     * @return GameItem
     */
    public GameItem getShape(ImageButton shapeButton, TextView shapeName) {

        //how many game items we have to work with
        int numberGameItems = 8;

        //random number generator
        Random random = new Random();
        int randomNumber = random.nextInt(numberGameItems);

        //this prevents the same game item from spawned twice in a row
        while (randomNumber == previousNumber) {
            randomNumber = random.nextInt(numberGameItems);
        }

        //this switch decides which gameItem to return based on int value
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






