/*
 *  File:           <filename>
 *  Author:         <name>
 *  Last modified:  <date>
 * 
 *  This class includes methods that make decisions
 */

//---------------------------------------------

public class h2 {
  
//---------------------------------------------
  
  // greatest3() takes 3 doubles and returns the largest
  public static double greatest3(double a, double b, double c) {
    double result = 0.0;
    result = a;
    if (a > b && a > c) {
      result = a;
    } else if (b > c) {
      result = b;
    } else {
      result = c;
    }    
        
    return result;
  }
  
//---------------------------------------------
  
  
  // allDiff3() takes three doubles and determines
  // if they are all different, returning a Boolean
  public static boolean allDiff3(double a, double b, double c) {
    boolean result;
    result = false;
    if (!(a == b || a == c || b == c)) {
      result = true;
    }
    
    return result;
  }
  
  //---------------------------------------------
  
  
  // inOrder3() takes three doubles and determines if they are in order,
  // returning a boolean.
  public static boolean inOrder3(double a, double b, double c) {
    boolean result;
    result = false;
    if (a <= c && a <= b && b <= c) {
      result = true;
    }
    
    return result;
  }
  
  //---------------------------------------------
  
  // sumGreatest23() takes three doubles and returns the sum
  // of the two largest ones
  public static double sumGreatest23(double a, double b, double c) {
    double result = 0.0;
    double greatest = greatest3(a,b,c);
    double greater;
    if ( greatest == a) {
      greater = greatest3(b,c,c);
    } else if (greatest == b) {
      greater = greatest3(a,c,c);
    } else {
      greater = greatest3(a,b,b);
    }
    result = greatest + greater;
    return result;
  }
  //---------------------------------------------
  
  // isRight() takes three doubles and determines if
  // they can form the sides of a right triangle, returning aBoolean
  public static boolean isRight(double x, double y, double z) {
    boolean result = false;
    double hyp = greatest3(x,y,z);
    if (hyp == x) {
      if (((y*y) + (z*z)) == (hyp*hyp)) {
        result = true;
      }
    } else if (hyp == y) {
      if (((x*x) + (z*z)) == (hyp*hyp)) {
        result = true;
      }
    } else {
      if (((x*x) + (y*y)) == (hyp*hyp)) {
        result = true;
      }
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
  public static double addOrMult(double a, double b, double c, boolean isMult) {
    double result = 0.0;
    if (isMult) {
      result = a * b * c;
    } else {
      result = a + b + c;
    }
    
    return result;
  }
  
  //---------------------------------------------
  
  // diffOrOrder3() takes three doubles,
  // returning the allDiff3() if their sum is less than 10
  // and the inOrder3() otherwise.
  public static boolean diffOrOrder3(double a, double b, double c) {
    boolean result = false;
    if ((a + b + c) < 10) {
      result = allDiff3(a,b,c);
    } else {
      result = inOrder3(a,b,c);
    }
    
    return result;
  }
  
  //---------------------------------------------
  
  // greater2Or3() takes five doubles and returns the larger of
  // the sum of the two largest and the sum of the three smallest
  
  // helper function to find max of two numbers
  public static double max(double a, double b) {
    double result = 0.0;
    double temp = 0.0;
    
    if (a > b) {
      result = a;
    } else {
      result = b;
    }
    
    return result;
  }
     
  public static double greater2Or3(double a, double b, double c, double d, double e) {
    double result = 0.0;
    double temp = 0.0;
    double max = 0.0;
    
    // find max of a,b,c,d,e and replace a
    max = max(a, max(b, max(c, max(d, e))));
    if (a == max) {
      a = max;
    }
    else if (b == max) {
      temp = a;
      a = max;
      b = temp;
    } else if (c == max) {
      temp = a;
      a = max;
      c = temp;
    } else if (d == max) {
      temp = a;
      a = max;
      d = temp;
    } else {
      temp = a;
      a = max;
      e = temp;
    }
    // find max of b,c,d,e and replace b
    max = max(b, max(c, max(d, e)));
    if (b == max) {
      b = max;
    }
    else if (c == max) {
      temp = b;
      b = max;
      c = temp;
    } else if (d == max) {
      temp = b;
      b = max;
      d = temp;
    } else {
      temp = b;
      b = max;
      e = temp;
    }
    // find max of c,d,e and replace c
    max = max(c, max(d, e));
    if (c == max) {
      c = max;
    }
    else if (d == max) {
      temp = c;
      c = max;
      d = temp;
    } else {
      temp = c;
      c = max;
      e = temp;
    }
    // find max d,e and replace d
    max = max(d,e);
    if (d == max) {
      d = max;
    }
    else {
      temp = d;
      d = max;
      e = temp;
    }
       
    // find larger of the sums
    if ((a+b) > (c+d+e)) {
      result = a + b;
    } else {
      result = c + d + e;
    }
    
    return result;
  }

//---------------------------------------------
  
} // end class h2a
