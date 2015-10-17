/*
 *  File:           h2.java
 *  Author:         Chris Fenton
 *  Last modified:  10/16/2015
 * 
 *  This class includes methods that make decisions
 */

//---------------------------------------------

public class h2 {
  

  // Helper methods
  public static double max(double a, double b) {
    double result = b;
    if (a > b) {
      result = a;
    }
        
    return result;
  }
  public static double min(double a, double b) {
    double result = b;
    if (a < b) {
      result = a;
    }
        
    return result;
  }
  public static double maxOf4(double a, double b, double c, double d) {
    double result = 0.0;
    result = max(a,max(b,max(c,d)));
    
    return result;
  } // End helper methods
  
//---------------------------------------------
  
  // greatest3() takes 3 doubles and returns the largest
  public static double greatest3(double a, double b, double c) {
    double result = 0.0;
    result = max(a,max(b,c));
    
    return result;
  }
  
//---------------------------------------------
  
  
  // allDiff3() takes three doubles and determines
  // if they are all different, returning a Boolean
  public static boolean allDiff3(double a, double b, double c) {
    boolean result = false;
    if (a != b && a != c && b != c) {
      result = true;
    }
    
    return result;
  }
  
  //---------------------------------------------
  
  
  // inOrder3() takes three doubles and determines if they are in order,
  // returning a boolean.
  public static boolean inOrder3(double a, double b, double c) {
    boolean result = false;
    if (a <= b && b <= c) {
      result = true;
    }
    
    return result;
  }

  
  //---------------------------------------------
  
  // sumGreatest23() takes three doubles and returns the sum
  // of the two largest ones
  public static double sumGreatest23(double a, double b, double c) {
    double result = 0.0;
    double min = min(a,min(b,c));
    result = a + b + c - min;
    
    return result;
  }
  
//---------------------------------------------
  
  // isRight() takes three doubles and determines if
  // they can form the sides of a right triangle, returning aBoolean
  public static boolean isRight(double x, double y, double z) {
    boolean result = false;
    double c = greatest3(x,y,z); // find hypotenuse
    double a = min(x,(min(x,y))); // shortest side
    double b = x + y + z - c - a; // identify the third side
    if (a * a + b * b == c * c) {
      result = true;
    }
    
    return result;
  }
  
  //---------------------------------------------
  
  // countGreater34 takes four doubles and returns the number
  // of the first three numbers that are larger than the fourth
  public static double countGreater34(double a, double b, double c, double d) {
    double result = 0;
    if (a > d) {
      result += 1;
    }
    if (b > d) {
      result += 1;
    }
    if (c > d) {
      result += 1;
    }
    
    return result;
  }
  
  //---------------------------------------------
  
  // addOrMult() takes three doubleegers and a Boolean. If the
  // boolean is false it returns the sum of the doubles.
  // If the boolean is true, it returns the product of the doubles.
  public static double addOrMult(double a, double b, double c, boolean flag) {
    double result = a * b * c;
    if (!flag) {
      result = a + b + c;
    }
    
    return result;
  }
  
//---------------------------------------------
  
  // diffOrOrder3() takes three doubles,
  // returning the allDiff3() if their sum is less than 10
  // and the inOrder3() otherwise.
  public static boolean diffOrOrder3(double a, double b, double c) {
    boolean result = inOrder3(a,b,c);
    if (a + b + c < 10) {
      result = allDiff3(a,b,c);
    }
    
    return result;
  }
  
  //---------------------------------------------
  
  // greater2Or3() takes five doubles and returns the larger of
  // the sum of the two largest and the sum of the three smallest 
  public static double greater2Or3(double a, double b, double c, double d, double e) {
    double result = 0.0;
    double max = max(a,max(b,max(c,max(d,e))));
    double max2 = 0.0;
    double top2 = 0.0;
    double bottom3 = 0.0;
    
    // find the second largest number
    if (max == a) {
      max2 = maxOf4(b,c,d,e);
    } else if (max == b) {
      max2 = maxOf4(a,c,d,e);
    } else if (max == c) {
      max2 = maxOf4(a,b,d,e);
    } else if (max == d) {
      max2 = maxOf4(a,b,c,e);
    } else {
      max2 = maxOf4(a,b,c,d);
    }
    top2 = max + max2; // sum the 2 largest numbers
    bottom3 = a + b + c + d + e - top2; // sum the 3 smallest numbers
    
    if (top2 > bottom3) {
      result = top2;
    } else {
      result = bottom3;
    }
    
    return result;
  }

//---------------------------------------------
  
} // end class h2a
