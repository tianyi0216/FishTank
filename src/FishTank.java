import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

public class FishTank extends PApplet{
  private PImage backgroundImage; // PImage object which represents the background image
  protected ArrayList<TankListener> objects; // list storing interactive objects
  protected Random randGen; // Generator of random numbers
  
  private TankObject flower;
  private TankObject log;
  private TankObject ship;
  private TankObject shell;
  
  //sets the size of this PApplet to 800 width x 600 height
  @Override
  public void settings() {
    size(800, 600);
  }

  // Defines initial environment properties such as screen size and
  // loads the background image and fonts as the program starts.
  // It also initializes all data fields.
  // The above IS NOT a javadoc style method header!
  @Override
  public void setup() {
    // Set and display the title of the display window
    this.getSurface().setTitle("Fish Tank 3000");
    // Set the location from which images are drawn to CENTER
    this.imageMode(PApplet.CENTER);
    // Set the location from which rectangles are drawn.
    this.rectMode(PApplet.CORNERS);
    // rectMode(CORNERS) interprets the first two parameters of rect() method
    // as the location of one corner, and the third and fourth parameters as
    // the location of the opposite corner.
    // rect() method draws a rectangle to the display window

    this.focused = true; // Confirms that our Processing program is focused,
    // meaning that it is active and will accept mouse or keyboard input.

    // sets the text alignment to center
    this.textAlign(PApplet.CENTER, PApplet.CENTER);

    // TODO load the background image and store the loaded image to backgroundImage
    // Note that you can call the loadImage() method directly (this.loadImage())
    backgroundImage= this.loadImage("images" + File.separator + "background.png");
    
    // TODO create an empty array list of objects
    this.objects = new ArrayList<TankListener>();
    // TODO set randGen to the reference of a new Random objects
    this.randGen = new Random();
    
    TankObject.setProcessing(this);
    
    this.flower = new TankObject(430, 60, "images" + File.separator + "flower.png");
    this.log = new TankObject(580, 470, "images" + File.separator + "log.png");
    this.shell = new TankObject(65, 520, "images" + File.separator + "shell.png");
    this.ship = new TankObject(280, 535, "images" + File.separator + "ship.png");
    
    this.objects.add(flower);
    this.objects.add(log);
    this.objects.add(shell);
    this.objects.add(ship);
    
    BlackFish fish1 = new BlackFish(log, flower);
    BlackFish fish2 = new BlackFish(shell, flower);
    this.objects.add(fish1);
    this.objects.add(fish2);
    
    Button.setProcessing(this);
    
    AddBlueFishButton blue=new AddBlueFishButton(43,16);
    AddYellowFishButton yellow = new AddYellowFishButton(215, 16);
    AddOrangeFishButton orange = new AddOrangeFishButton(129, 16);
    ClearTankButton clear = new ClearTankButton(301, 16);
    this.objects.add(blue);
    this.objects.add(orange);
    this.objects.add(yellow);
    this.objects.add(clear);
    
    
  }

  // Continuously draws and updates the application display window
  @Override
  public void draw() {
    // TODO clear the display window by drawing the background image
    this.image(backgroundImage, this.width/2, this.height/2);
    
    // TODO traverse the objects list and draw each of the objects to this display window
    for(int i=0; i<objects.size(); i++) {
      if(objects.get(i) != null)
        objects.get(i).draw();
    }
  }

  // Callback method called each time the user presses the mouse
  @Override
  public void mousePressed() {
    // TODO traverse the objects list and call mousePressed method
    // of the first object being clicked in the list
    for(int i=0; i<objects.size(); i++) {
      if(objects.get(i).isMouseOver()) {
        objects.get(i).mousePressed();
        break;
      }
    }
  }

  // Callback method called each time the mouse is released
  @Override
  public void mouseReleased() {
    // TODO traverse the objects list and call each object's mouseReleased() method
    for(int i=0; i<objects.size(); i++) {
      objects.get(i).mouseReleased();
    }
  }

  // adds an instance of TankListener passed as input to the objects arraylist
  public void addObject(TankListener object) {
    this.objects.add(object);

  }

  // Callback method called each time the user presses a key
  @Override
  public void keyPressed() {
   // To be implemented later in the next sections
    switch (Character.toUpperCase(this.key)) {
      case 'O' :
        objects.add(new Fish());
        break;
      case 'Y':
        objects.add(new Fish(2, "images" + File.separator + "yellow.png"));
        break;
      case 'R':
        for(int i=0; i<objects.size(); i++) {
          if(objects.get(i) instanceof Fish && objects.get(i).isMouseOver()) {
            objects.remove(i);
            break;
          }
        }
        break;
      case 'S':
        for(int i=0; i<objects.size(); i++) {
          if(objects.get(i) instanceof Fish)
            ((Fish)objects.get(i)).startSwimming();
        }
        break;
      case 'X':
        for(int i=0; i<objects.size(); i++) {
          if(objects.get(i) instanceof Fish)
            ((Fish)objects.get(i)).stopSwimming();
        }
        break;
      case 'C':
        this.clear();
        break;
      case 'B':
        objects.add(new BlueFish());
        break;
    }
  }
  
  //Removes instances of the class Fish from this tank
  public void clear() {
    for(int i=0; i<objects.size(); i++) {
      if(objects.get(i) instanceof Fish) {
        objects.remove(i);
        i--;
      }
    }
  }
  
  public static void main(String[] args) {
    PApplet.main("FishTank");
    
  }
}
