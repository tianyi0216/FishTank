//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Fish Tank 3000 Black Fish
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
// Online Sources:  https://stackoverflow.com/questions/23302698/java-check-if-two-rectangles-overlap-at-any-point 
//                  helped with how to see if object is over another
//
///////////////////////////////////////////////////////////////////////////////

import java.io.File;

/**
 * The black fish sub-class of the fish class
 * @author Tianyi Xu, Bill Zhu
 */
public class BlackFish extends Fish {
  private TankObject source; // source object for the fish to move away from
  private TankObject destination; // destination object the fish move to
  
  /**
   * constructor that create a blackFish object
   * @param source the TankObject fish to move away from
   * @param destination the TankObject fish move to
   */
  public BlackFish(TankObject source, TankObject destination) {
    super(2, "images" + File.separator + "black.png");
    this.source = source;
    this.destination = destination;
  }
  
  /**
   * makes the black fish one speed move towards destination
   */
  public void moveTowardsDestination() {
    
    // set the oldX and oldY to the current position of fish
    float oldX = this.getX();
    float oldY = this.getY();
    
    // find the difference of x position and y between destination and current position
    float dx = destination.getX() - oldX;
    float dy = destination.getY() - oldY;
    
    // d, the straight line distance between position by applying pythagorean theorem
    int d = (int)Math.sqrt(dx*dx + dy*dy);
    
    // new position of fish 1 speed move away from current position
    float newX = oldX + (this.speed() * dx)/d;
    float newY = oldY + (this.speed() * dy)/d;
    
    // set the new position of blackFish
    this.setX(newX);
    this.setY(newY);
  }
  
  /**
   * checks if the fish object is over the TankObject
   * @param other the TankObject to be compared to
   * @return true if it is over, false otherwise
   */
  public boolean isOver(TankObject other) { 
    
    // x1, x2, y1, y2 is the fish object's position's x and y's diagonal
    float x1 = this.getX() - this.image.width/2;
    float y1 = this.getY() - this.image.height/2;
    float x2 = this.getX() + this.image.width/2;
    float y2 = this.getY() + this.image.height/2;
    
    // x3, x4, y3. y4 is the diagonal position of the object
    float x3 = other.getX() - other.image.width/2;
    float y3 = other.getY() - other.image.height/2;
    float x4 = other.getX() + other.image.width/2;
    float y4 = other.getY() + other.image.height/2;
    
    // if one of the case is true, the fish is over the object
    return ((x1 < x4) && (x3 < x2) && (y1 < y4) && (y3 < y2));
  }
  
  /**
   * move the fish between towards the destination
   * if arrives, switch source to destination
   * Overrides Fish.swim() method
   */
  @Override
  public void swim() {
    
    // check if fish is over destination object, switch source and destination if it is true
    if(this.isOver(destination)) {
      TankObject tmp = source;
      source = destination;
      destination = tmp;
    }
    
    this.moveTowardsDestination();
  }
}
