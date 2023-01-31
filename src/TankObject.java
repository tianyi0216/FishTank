//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Fish Tank 3000 Tank Object
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
//   X Write-up states that pair programming is allowed for this assignment.
//   X We have both read and understand the course Pair Programming Policy.
//   X We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         N/A
// Online Sources:  N/A
//
///////////////////////////////////////////////////////////////////////////////

import processing.core.PImage;

/**
 * A class that represent an object that will be placed inside the fish tank
 * @author Tianyi Xu and William Zhu
 */
public class TankObject implements TankListener{
 
  protected static FishTank tank; // PApplet object which represents the display window
  protected PImage image; // image of this tank object
  private float x; // x-position of this tank in the display window
  private float y; // y-position of this tank in the display window
  private boolean isDragging; // indicates whether this tank object is being dragged or not
  private static int oldMouseX; // old x-position of the mouse
  private static int oldMouseY; // old y-position of the mouse
  
  /**
   * constructor of any tank object
   * @param x the x position of the object
   * @param y the y position of the object
   * @param imageFileName the file name of the object
   */
  public TankObject(float x, float y, String imageFileName) {
    this.image = tank.loadImage(imageFileName);
    this.x = x;
    this.y = y;
    this.isDragging = false;
  }
  
  /**sets the PApplet graphic display window for all TankObjects
   * @param tank the display window of the fish tank
   */
  public static void setProcessing(FishTank tank) {
    TankObject.tank = tank;
  }
  
  /**
   * moves this tank object with dx and dy
   * @param dx move dx to the x-position of this tank object
   * @param dy move dy to the y-position of this tank object
   */
  public void move(int dx, int dy) {
    this.x += dx;
    this.y += dy;
  }
  
  /**
   * returns the x-position of this tank object
   * @return x the x-position of this tank object
   */
  public float getX() {
    return x;
  }
  
  /**
   * returns the y-position of this tank object
   * @return y the y position of this tank object
   */
  public float getY() {
    return y;
  }
  
  /**
   * sets the x-position of this object
   * @param x the new x position of the object
   */
  public void setX(float x) {
    this.x = x;
  }
  
  /**
   * sets the y-position of this object
   * @param y the new y position of this object
   */
  public void setY(float y) {
    this.y = y;
  }

  /**
   * returns the image of this tank object
   * @return image the image of this tank object
   */
  public PImage getImage() {
    return this.image;
  }
  
  /**
   * setter of the isDragging field.
   * @return true if the object is being dragged
   */
  public boolean isDragging() {
    return this.isDragging;
  }
  
  /**
   * starts dragging this tank object by set isDragging is true
   */
  public void startDragging() {
    
    oldMouseX = tank.mouseX;
    oldMouseY = tank.mouseY;
    this.isDragging = true;
  }
  
  /**
   * stops dragging this tank object and set isDragging false
   */
  public void stopDragging() {
    this.isDragging = false;
  }

  /**
   * draw the object on the display window
   * override the draw() method in TankListener
   */
  @Override
  public void draw() {
    int dx = tank.mouseX - oldMouseX;
    int dy = tank.mouseY - oldMouseY;
    
    // if the object is being dragged, move along by adding dx and dy to current position
    // set oldMouseX and oldMouseY after being moved for next round of movement
    if (this.isDragging) {
      move(dx, dy);
      oldMouseX = tank.mouseX;
      oldMouseY = tank.mouseY;
    }
    
    tank.image(this.getImage(), this.x, this.y);
  }

  
  /**
   * call startDragging, which set isDragging true when mouse is pressed on the object
   * override the mousePressed() method in TankListener
   */
  @Override
  public void mousePressed() {
    this.startDragging();
  }

 
  /**
   * call stopDragging on the object if mouse is pressed on the object
   * override the mouseReleased() method in TankListener
   */
  @Override
  public void mouseReleased() {
    this.stopDragging();
  }

 
  /**
   * return whether the mouse is over the current object or not
   * override the isMouseOver() method in TankListener
   * @return true if mouse is over the current object, false otherwise
   */
  @Override
  public boolean isMouseOver() {
    return tank.mouseX >= x - image.width / 2 && tank.mouseX <= x + image.width / 2
        && tank.mouseY >= y - image.height / 2 && tank.mouseY <= y + image.height / 2;
  }
}
