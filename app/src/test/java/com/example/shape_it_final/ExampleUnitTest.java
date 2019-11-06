package com.example.shape_it_final;

import org.junit.Test;

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

    @Test
    public void soundFile_notNull() { assertNotNull("Game Item is NULL", GameItemTriangle);}

    @Test
    public void imageFile_notNull() { assertNotNull("Image is NULL",GameItemImage);}

    @Test
    public void showsName_isTrue() { assertTrue("Name is true", showsName());}

}