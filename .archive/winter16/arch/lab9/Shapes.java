class Shapes {

  public static void main(String[] args) {

    final int MAXSHAPES = 3;
	Shape[] shapes = new Shape[MAXSHAPES];

	shapes[0] = new Rectangle(3,4);
	shapes[1] = new Circle(5);
	shapes[2] = new Square(5);
	  
	for (int i = 0; i < MAXSHAPES; i++) {
	  System.out.println(i + ") " + shapes[i].toString()
								  + " with area " + shapes[i].area());
	}
  }

}
