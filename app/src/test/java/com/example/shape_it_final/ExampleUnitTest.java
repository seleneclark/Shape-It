package com.example.shape_it_final;

import android.content.Intent;

import org.junit.Rule;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


//    @Test
//    public void currentShapeID_notNull() {
//        ShapeActivity testGameActivity = new ShapeActivity();
//        assertNotNull("There is no ID for a shape item", testGameActivity.currentShapeID);
//    }

//    @Test
//    public void circle_notNull() {
//        ShapeActivity testGameActivity = new ShapeActivity();
//        Circle circle = new Circle(testGameActivity.shapeButton, testGameActivity.shapeName);
//        circle.showsName();
//        boolean test = false;
//        test = Pattern.matches(testGameActivity.shapeName.getText().toString(),"Circle");
//        assertTrue("Circle:  the names match", test);
//    }

//    @Test
//    public void gameItem_notNull() {
//        ShapeActivity testGameActivity = new ShapeActivity();
//        assertNotNull("There is no for a shape item", testGameActivity.gameItem);
//    }
//
//    @Test
//    public void shapeName_notNull() {
//        ShapeActivity testGameActivity = new ShapeActivity();
//        assertNotNull("There is no TextView shapeName", testGameActivity.shapeName);
//    }
//
//    @Test
//    public void shapeButton_notNull() {
//        ShapeActivity testGameActivity = new ShapeActivity();
//        assertNotNull("There is no ImageButton shapeButton", testGameActivity.shapeButton);
//    }

/*
    @Test
    public void soundFile_notNull() { assertNotNull("Game Item is NULL", GameItemTriangle);}

    @Test
    public void imageFile_notNull() { assertNotNull("Image is NULL",GameItemImage);}

    @Test
    public void showsName_isTrue() { assertTrue("Name is true", showsName());}
*/
}