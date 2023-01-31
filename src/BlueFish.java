import java.io.File;

public class BlueFish extends Fish {
  public BlueFish() {
    super(2, "images" + File.separator + "blue.png");
  }

  @Override
  public void swim() {
    this.move(this.speed() *-1, 0);
    if(this.getX() <= 0)
      this.setX(tank.width);
  }
}
