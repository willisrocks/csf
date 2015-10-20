/*
 *  File:           h4a.java
 *  Author:         Chris Fenton
 *  Last modified:  10/20/2015
 * 
 *  This class includes methods that use the for statement
 */

//---------------------------------------------

public class h4 {
  
  // helper functions
  public static boolean isEven(int x) {
    boolean result = false;
    
    if(x % 2 == 0) {
      result = true;
    }
    
    return result;
  }
  
  public static int max(int x, int y) {
    int result = y;
    if (x > y) {
      result = x;
    }
    return result;
  }
  
  public static int min(int x, int y) {
    int result = y;
    if (x < y) {
      result = x;
    }
    return result;
  }
  
  
//---------------------------------------------
  
  /* sumTo() takes an integer x and returns the sum
   * 1+2+3..n
   */
  public static int sumTo(int x) {
    int result = 0;
    int sum = 0;
    
    for(int i=1;i<=x;i++) {
      sum += i;
    }
    
    result = sum;
    
    return result;
  } // end sumTo()
  
//---------------------------------------------
  
  
  /* sumOfSums() takes an integer x and returns the sum of the
   * sumTo of 1, 2, .., x
   */
  public static int sumOfSums(int x) {
    int result = 0;
    int sum = 0;
    
    for (int i=1;i<=x;i++) {
      sum += sumTo(i);
    }
    
    result = sum;
    
    return result;
  }
  
//---------------------------------------------
  
  /*sumOfEvenBetween() takes two integers, x and y,
   * and returns the sum of all integers
   */
  public static int sumOfEvenBetween(int x, int y) {
    int result = 0;
    int sum = 0;
    int start = min(x,y);// min (x,y)
    int end = max(x,y);//max(x,y)
    
    for (int i = start; i <= end; i++) {
      if(isEven(i)) {
        result += i;
      }
    }
    
    return result;
  }
 
  
//---------------------------------------------  
 
  /* sumPropDivisors() takes a number, x, and
   * returns the sum of its proper divisors
   */
 
  
//---------------------------------
  
  /* isPerfect() takes an integer x and returns
   * a boolean. It returns true of the number
   * is perfect, a nummber that equals the sum
   * of its proper divisors
   */
  
//---------------------------------
  
  /* isPrime() takes an integer x and determines
   * if the number is prime, returning a boolean.
   */


//---------------------------------

//LOOK at THE PDF FOR THE TWO "EXTRA CREDIT" problems!
  
//==========================================
  
} // end class h4a
