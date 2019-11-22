package com.example.shape_it_final;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * GameItem interface
 *
 * A GameItem is an item that will appear in the GameActivity
 * to be touched where it will then show its name and say its name.
 * Current GameItems:
 *      Triangle
 *      Square
 *      Circle
 *
 * Future types of GameItems:
 *      Shape - several different shapes
 *      Number
 *      Color
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
