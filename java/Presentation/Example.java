class Example {

  public static void main(String[] args) {
    // Rectangle (Super Class)
    Rectangle my_rectangle = new Rectangle(4,3);
    System.out.println("4 x 3 rectangle, area:");
    System.out.println(my_rectangle.area());

    // Square (Child Class)
    Square my_square = new Square(4);
    System.out.println("4 x 4 square, area:");
    System.out.println(my_square.area());
  }
}
