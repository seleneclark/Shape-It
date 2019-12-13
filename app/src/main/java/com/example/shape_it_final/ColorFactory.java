package com.example.shape_it_final;

import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;


/**
 * This is a factory that creates the shapes for the Color Game
 *
 * This factory will randomly create a color when it is called.  It can can create
 * Orange, Blue, Green, Pink, Purple, Red or Yellow.
 */
public class ColorFactory {

    //this holds a value to prevent the same color from showing up twice in a row
    int previousNumber;

    /**This function randomly generates a color to send to GameActivity
     *
     * This factory will randomly create a color when it is called.  It can can create
     * Orange, Blue, Green, Pink, Purple, Red or Yellow.
     *
     * @param colorButton The button where the color images appear
     * @param colorName The TextView where the name of the color appears
     * @return GameItem
     */
    public GameItem getColor(ImageButton colorButton, TextView colorName) {
        int numberGameItems = 7;
        Random random = new Random();
        int randomNumber = random.nextInt(numberGameItems);

        while (randomNumber == previousNumber) {
            randomNumber = random.nextInt(numberGameItems);
        }

        switch (randomNumber) {
            case 0:
                previousNumber = 0;
                return new Orange(colorButton, colorName);
            case 1:
                previousNumber = 1;
                return new Blue(colorButton, colorName);
            case 2:
                previousNumber = 2;
                return new Green(colorButton, colorName);
            case 3:
                previousNumber = 3;
                return new Pink(colorButton, colorName);
            case 4:
                previousNumber = 4;
                return new Purple(colorButton, colorName);
            case 5:
                previousNumber = 5;
                return new Red(colorButton, colorName);
            case 6:
                previousNumber = 6;
                return new Yellow(colorButton, colorName);
            default:
                return null;
        }
    }
}
