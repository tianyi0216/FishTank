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

/**
 * A class of a clear tank button that clears all fish when clicked
 * @author Tianyi and Bill Zhu
 */
public class ClearTankButton extends Button {
  
  /**
   * create a ClearTankButton obejct at a position with a clear string
   * @param x x position of the button
   * @param y y position of the button
   */
  public ClearTankButton(float x, float y) {
    super("clear", x, y);
  }
  
  /**
   * clear the tank when mouse is pressed by calling clear method
   * override the mousePressed method in Button class
   */
  @Override
  public void mousePressed() {
    tank.clear();
  }
}
