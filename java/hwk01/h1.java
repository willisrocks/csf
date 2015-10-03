/*
*  File:           h1.java
*  Author:         Chris Fenton
*  Last modified:  10-1-15
* 
*  This class implements a number of simple arithmetic methods.
*/

//---------------------------------------------

public class h1 {

  
//---------------------------------------------
  
/* Constants: 
 * 
 */
  private static final double PI = 3.14159;
     
  
//---------------------------------------------
  
//---------------------------------------------
  
/* Method: multBy2()
 * This method returns the multiplication of a double by 2.
 */
  
  public static double multBy2(double x) {
    double result = 0.0;
    result = 2.0 * x;
    return result;   
  } // end multBy2
  
//---------------------------------------------
  
    
/* Method: myMult()
 * This method returns the multiplication of two doubles.
 */
  
  public static double myMult(double x, double y) {
    double result = 0.0;
    result = x * y;
    
    return result;
    
  } // end myMult
  
//---------------------------------------------
  
/* Method: square()
 * This method returns the square of a double.
 */
  
  public static double square(double x) {
    double result = 0.0;
    result = x * x;
      
    return result;
  }
  
  
//---------------------------------------------
  
  /* Method: circleArea()
 * This method returns the area of a circle given
 * the radius of the circle.
 */
  
  public static double circleArea(double x) {
    double result = 0.0;
    result = PI * x * x;
    
    return result;
  }
  
  
//---------------------------------------------
  
  /* Method: fToC()  
   * This method converts a temperature in Fahrenheit to a temperature
   * in Celsius.
   */
  
  public static double fToC(double f_temp) {
    double result = 0.0;
    result = (f_temp - 32) * 5.0/9.0;
    
    return result;
  }
  
  
//---------------------------------------------
  
  /* Method: secToDistanceDrop()  
   * This method returns the number of feet an object 
   * would fall on earth after a given number of seconds
   */
  
  public static double secToDistanceDrop(double sec) {
    double result = 0.0;
    result = (32.0 * square(sec)) / 2.0;
    
    return result;
  }
  
  
//---------------------------------------------
  
  /* Method: hypotLength()  
   * This method returns the length of a right triangle's 
   * hypotenuse given the two shorter sides.
   */
  
  public static double hypotLength(double a, double b) {
    double result = 0.0;
    result = Math.sqrt(square(a) + square(b));
    
    return result;
  }
  
  
//---------------------------------------------
  
  /* Method: triangleArea()  
   * This method returns the area of a triangle 
   * given the two shorter sides. It uses Heron's formula
   */
  
  public static double triangleArea(double a, double b, double c) {
    double result = 0.0;
    double s = 0.0;
    s = (a + b + c) / 2;
    result = Math.sqrt(s * (s - a) * (s - b) * (s - c));
    
    return result;
  }
  
//---------------------------------------------
  
  /* Method: ringArea()  
   * This method returns the area of a ring 
   * given by defined by concentric circles of
   * different radii. You should assume that the
   * first parameter is the larger radii.
   */
  
  public static double ringArea(double outer_r, double inner_r) {
    double result = 0.0;
    result = PI * (square(outer_r) - square(inner_r));
    
    return result;
  }
  
  
//---------------------------------------------
  
} // end class h1
