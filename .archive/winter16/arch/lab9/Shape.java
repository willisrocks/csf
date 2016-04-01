abstract public class Shape {

  // (x,y) location is common to all classes of shapes
  // We don't use it here (we don't provide any way to initialize location).
  private int x;
  private int y;

  abstract public double area();
  abstract public String toString();
}
