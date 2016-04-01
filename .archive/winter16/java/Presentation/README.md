## Inheritance Demo

### Rectangle.java
Rectangle.java is the parent or super class. It has 2 fields: width and height. It has 2 constructors for the case where you pass a width and a height and the case where you only pass a width. Rectangle provides an area() method to calulate the area of the rectangle (w x h).

### Square.java
Square.java is the child class that inherits from Rectangle.java. It only contains a constructor that calls the constructor from Rectangle.

### Example.java
Example.java creates a Rectangle and a Square, printing out the areas of both objects. It demonstrates how Square inherited the fields and methods from Rectangle.
