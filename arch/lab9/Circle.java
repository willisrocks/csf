public class Circle extends Shape {
  private double radius;

  public Circle(double r) {
    radius = r;
    }

  public double area() {
    return (3.14 * radius * radius);
    }

  public String toString() {
    return ("I'm a circle");
  }
}
