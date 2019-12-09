package com.example.shape_it_final;

import android.content.Context;

/**
 * GameItem interface
 *
 * A GameItem is an item that will appear in the ShapeActivity or ColorActivity
 * to be touched where it will then show its name and say its name.
 * GameItems for ShapeActivity:
 *      Triangle
 *      Square
 *      Circle
 *      Heart
 *      Oval
 *      Pentagon
 *      Rectangle
 *      Star
 *
 * GameItems for ColorActivity:
 *      Blue
 *      Green
 *      Orange
 *      Pink
 *      Purple
 *      Red
 *      Yellow
 *
 * Methods:
 *  draw() - Draw will draw the GameItem on the screen
 *  showsName() - will make the name of the GameItem appear
 *  saysName() - will say the name of the GameItem
 *  clearName() - will clear the name from the screen
 */

public interface GameItem {
    /**
     * Draws the GameItem on the screen
     * */
    void draw();
    /**
     * Makes the name of the GameItem appear
     * */
    void showsName();
    /**
     * Says the name of the GameItem
     * */
    void saysName(Context context);
    /**
     * Clears the name from the screen
     */
    void clearName();
}
