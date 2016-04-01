class Rectangle {
  int width;
  int height;

  public Rectangle(int w, int h) {
    this.width = w;
    this.height = h;
  }

  public Rectangle(int w) {
    this.width = w;
    this.height = w;
  }

  public int area() {
    return width * height;
  }

}
