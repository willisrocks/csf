/*
 *  File:           h3.java
 *  Author:         Chris Fenton
 *  Last modified:  10/15/2015
 * 
 *  This class includes methods that make decisions
 */

//---------------------------------------------

public class h3 {

//---------------------------------------------
  // Helper methods
  
  // max() returns the larger of 2 integers
  public static int max(int a,int b) {
    int result = b;
    if (a > b) {
      result = a;
    }
    
    return result;
  } // end max()  
  
  // min() returns the smaller of 2 integers
  public static int min(int a,int b) {
    int result = b;
    if (a < b) {
      result = a;
    }
    
    return result;
  } // end min()
  
  // dividesEven() returns true if 2 integers divide evenly
  public static boolean dividesEven(int a, int b) {
    boolean result = false;
    if (a % b == 0) {
      result = true;
    }    
    
    return result;
  }
  
  // isEven() returns true if an integer is even
  public static boolean isEven(int a) {
    boolean result = false;
    if (a % 2 == 0) {
      result = true;
    }
    return result;
  }
  
  // end Helper methods
  
//---------------------------------------------
  
  // greatest5() takes five integers and returns the largest
  public static int greatest5(int x,int y, int z, int a,int b) {
    int result = 0;
    
    result = max(x,(max(y,max(z,max(a,b)))));
    
    return result;
  } // end of greatest5()
//---------------------------------------------
  
  // sum45() takes five integers and returns the sum of the
  // largest four
  public static int sum45(int a, int b, int c, int d, int e) {
    int result = 0;
    int smallest = 0;
    
    smallest = min(a,min(b,min(c,min(d,e))));
    result = a + b + c + d + e - smallest;
    
    return result;
  }  
  
  //---------------------------------------------
  
  // anyDivide3() takes three integers and determines if any one number
  // divides another, returning a boolean. If any are 0, it returns
  // false.
  public static boolean anyDivide3(int a, int b, int c) {
    boolean result = false;
    boolean zero = false;
    
    if (a == 0 || b == 0 || c == 0) {
      zero = true;
    }
    if (!zero) {
      if (dividesEven(a,b) || dividesEven(a,c) || dividesEven(b,a) || dividesEven(b,c) || dividesEven(c,a) || dividesEven(c,b)) {
        result = true;
      }
    } 
    
    return result;
  }
  
  //---------------------------------------------
  
  /*
   *  sumEven4() takes four integers and returns the sum
   *  of all the numbers that are even.
   * 
   */
  public static int sumEven4(int a, int b, int c, int d) {
    int result = 0;
    int sum = 0;
    if (isEven(a)) {
      sum += a;
    }
    if (isEven(b)) {
      sum += b;
    }
    if (isEven(c)) {
      sum += c;
    }
    if (isEven(d)) {
      sum += d;
    }
    
    result = sum;
    return result;
  }
  
//=================================================
  
 /*
  * sumEvenProdOdd4()  takes four integers and returns an integer.
  * It should return the sum of the numbers that are even plus the 
  * product of the numbers that are odd. NOTE: If there are no odd
  * numbers then the product is 1.
  */
  public static int sumEvenProdOdd4(int a, int b, int c, int d) {
    int result = 0;
    int sum_even = sumEven4(a,b,c,d);
    int prod_odd = 1;
    
    if (!isEven(a)) {
      prod_odd *= a;
    }
    if (!isEven(b)) {
      prod_odd *= b;
    }
    if (!isEven(c)) {
      prod_odd *= c;
    }
    if (!isEven(d)) {
      prod_odd *= d;
    }
    
    result = sum_even + prod_odd;
    
    return result;
  }
  
} // end class h3
