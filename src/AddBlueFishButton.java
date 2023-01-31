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
 * A class where create a button that adds blue fish, sub-class of button class
 * @author Tianyi Xu and Bill Zhu
 */
public class AddBlueFishButton extends Button {
  
  /**
   * creates a AddBlueFishButton object with "Add Blue" text that will add blue fish to the tank
   * @param x the x position of the button
   * @param y the y position of the button
   */
  public AddBlueFishButton(float x, float y) {
    super("Add Blue", x, y);
  }
  
  /**
   * when the button is clicked by the mouse, add a fish to the object in the 
   * override the Button.mousePressed() method
   */
  @Override
  public void mousePressed() {
    tank.objects.add(new BlueFish());
  }
}
