//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Fish Tank 3000's Button
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
 * A class represents all the buttons in the fish tank
 * implements the TankListener interface
 * @author Tianyi Xu, Bill Zhu
 */
public class Button implements TankListener{
  
  private static final int WIDTH = 85; // width of the button field
  private static final int HEIGHT = 32; //height of the button field
  
  protected static FishTank tank; // PApplet object represent the graphic display window
  private float x; // the x position of the button
  private float y; // the y position of the button
  private String label; // the text on the button
  
  /**
   * creates a new Button at a given position within the display window and set its label
   * @param label the text to display on the button
   * @param x the x position of the button object
   * @param y the y position of the button object
   */
  public Button(String label, float x, float y) { 
    this.x = x;
    this.y = y;
    this.label = label;
  }
  
  /**
   * sets the he PApplet display window where this button is displayed and handled
   * @param tank the PApplet display window project
   */
  public static void setProcessing(FishTank tank) {
    Button.tank = tank;
  }

  /**
   * check whether mouse is over button
   * override the TankListener's isMouseOver() method
   * @return true if the mouse is over, false otherwise
   */
  @Override
  public boolean isMouseOver() {
    return tank.mouseX >= x - WIDTH / 2 && tank.mouseX <= x + WIDTH / 2
        && tank.mouseY >= y - HEIGHT / 2 && tank.mouseY <= y + HEIGHT / 2;
  }

  /**
   * draw the button to the display window
   * overrides TankListener.draw() method
   */
  public void draw() {
 
    tank.stroke(0);// set line value to black
    
    // check if mouse is over current button, fill it with dark grey, light grey if otherwise
    if(this.isMouseOver()) 
      tank.fill(100);
    else
      tank.fill(200);
  
    tank.rect(x - WIDTH / 2.0f, y - HEIGHT / 2.0f,
       x + WIDTH / 2.0f, y + HEIGHT / 2.0f);
    tank.fill(0); // set the fill color to black
    tank.text(label, x, y); // display the text of the current button
  }

  /**
   * print the string "a button was pressed" whenever mouse is pressed and mouse is over
   * overrides the TankListener.mousePressed() method
   */
  @Override
  public void mousePressed() {
    if(this.isMouseOver())
      System.out.println("A button was pressed.");
  }

  /**
   * implement default behavior of button when mouse is pressed, leave empty
   * must be overridden in sub class
   * overrides the TankListener.mouseReleased() method
   */
  @Override
  public void mouseReleased() { 
    // Leave this method empty
  }
}
