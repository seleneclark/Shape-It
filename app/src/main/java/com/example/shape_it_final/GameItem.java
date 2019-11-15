package com.example.shape_it_final;

/**
 * GameItem interface
 * A GameItem is an item that will appear in the GameActivity
 * to be touched where it will then show its name and say its name.
 * Current GameItems:
 *      Shape - currently just a triangle
 * Future GameItems:
 *      Shape - several different shapes
 *      Number
 *      Color
 */

public interface GameItem {

    void draw();
    void showsName();
    void saysName();
}
