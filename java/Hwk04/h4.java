/*
 *  File:           h4a.java
 *  Author:         Chris Fenton
 *  Last modified:  10/21/2015
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
  public static int sumPropDivisors(int x) {
    int result = 0;
    
    for(int i=1;i<x;i++) {
      if(x % i == 0) {
        result += i;
      }
    }
    
    return result;
  }
 
  
//---------------------------------
  
  /* isPerfect() takes an integer x and returns
   * a boolean. It returns true of the number
   * is perfect, a nummber that equals the sum
   * of its proper divisors
   */
  public static boolean isPerfect(int x) {
    boolean result = false;
    
    if(sumPropDivisors(x) == x) {
      result = true;
    }
    
    return result;
  }
  
//---------------------------------
  
  /* isPrime() takes an integer x and determines
   * if the number is prime, returning a boolean.
   */
  public static boolean isPrime(int x) {
    boolean result = false;
    int sumProp = sumPropDivisors(x);
    
    if(sumProp == 1 && x != 1) {
      result = true;
    }
    
    return result;
  }


//---------------------------------
  
  //LOOK at THE PDF FOR THE TWO "EXTRA CREDIT" problems!
  
  /* nthPerfect() takes an integer x and determines
   * the nth perfect number, returning an integer.
   */  
  public static int nthPerfect(int x) {
    int result = 0;
    int i = 1; 
    int k = 1;
    
    for(int n=1;k<=x;n++) {   
      if(isPerfect(i)) {
        result = i;
        k += 1;
      }
      i += 1;              
    }
    
    return result; // nthPerfect(4) return 8128
  }
  
//---------------------------------
  
  /* isAmicable() takes two integers,  x and y, and determines
   * if they are amicable, returning an boolean.
   */
  public static boolean isAmicable(int x, int y) {
    boolean result = false;
    
    if(x != y) {
      if(sumPropDivisors(x) == y && sumPropDivisors(y) == x) {
        result = true;
      }
    }
    
    return result;
  }
  
//---------------------------------
  /* nthAmicablePair() takes an integer x (less than 8) and determines
   * the nth amicable pair, printing the first x amicable pairs to the console.
   * restricting x to integers below 8 just to prevent long execution times.
   * inspiration from https://www.youtube.com/watch?v=IbhBki25KGc and projectEuler.
   */
  public static void nthAmicablePair(int x) {
    assert x < 8 : "x is greater than 8";
    
    int start = 2;
    int i = 1;
       
    for(int n=start;i<=x;n++) {
      int newNum = sumPropDivisors(n);
      if (newNum <= n) { // jump ahead if newNum is less than n
        continue;
      }
      if(isAmicable(newNum,n)) {
        System.out.println(i + " " + n + "," + newNum);
        i += 1;
      }  
    } // nthAmicablePair(2) returns 1 220, 284 and 2 1184,1210      
    
  }
//---------------------------------
  

  
//==========================================
  
} // end class h4a