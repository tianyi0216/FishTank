//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Fish Tank 3000 Add Blue Fish Button
// Course:   CS 300 Fall 2021
//
// Author:   Tianyi Xu
// Email:    txu223@wisc.edu
// Lecturer: Hobbes Legault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Bill Zhu
// Partner Email:   wlzhu@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _X_ Write-up states that pair programming is allowed for this assignment.
//   _X_ We have both read and understand the course Pair Programming Policy.
//   _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         N/A
// Online Sources:  N/A
//
///////////////////////////////////////////////////////////////////////////////

import java.io.File;

/**
 * A class that creates a button that adds yellow fish, subclass to Button class
 * @author Tianyi Xu and Bill Zhu
 */
public class AddYellowFishButton extends Button{
  
  /**
   * create a AddYellowFishButton object at position x and y and "Add Yellow" text
   * @param x x position of the button
   * @param y y position of the button
   */
  public AddYellowFishButton(float x, float y) {
    super("Add Yellow", x, y);
  }
  
  /**
   * add a yellow fish to the tank when mouse is pressed on the button
   */
  @Override
  public void mousePressed() {
    tank.objects.add(new Fish(2, "images" + File.separator + "yellow.png"));
  }
}
