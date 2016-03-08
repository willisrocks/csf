public class Square extends Shape {
  private double side;

  public Square(double s) {
    side = s;
    }

  public double area() {
    return (side * side);
    }

  public String toString() {
    return ("I'm a square");
  }
}
