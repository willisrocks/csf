public class Rectangle extends Shape {
  private double height, width;

  public Rectangle(double h, double w) {
    this.height = h;   // "this" isn't needed here, but I put it
    this.width = w;    // to emphasise that height and width
    }                  // have implicit object reference "this"

  public double area() {
    return (height*width);
    }

  public String toString() {
    return ("I'm a rectangle");
  }
}
