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
 * A class that simulate a button that adds orange fish to the fish tank
 * @author Tianyi Xu and Bill Zhu
 */
public class AddOrangeFishButton extends Button {
  
  /**
   * create an AddOrangeFishButton object at a position with add orange on it
   * @param x
   * @param y
   */
  public AddOrangeFishButton(float x, float y) {
    super("Add Orange", x, y);
  }
  
  /**
   * add a new orange fish to the tank when button is clicked
   * override the Button.mousePressed() method
   */
  @Override
  public void mousePressed() {
    tank.objects.add(new Fish());
  }
}
