/*
 *  File:           h6.java
 *  Author:         Chris Fenton
 *  Last modified:  11/14/2015
 * 
 *  This class contains mathemtical functions
 *  defined recursively.
 */

//---------------------------------------------

public class h6 {
  
  public static void revRec(int x) {
    int result = 0;
    
    if (x < 10) {
      System.out.println(x);
      
    } else {
      System.out.print(x % 10);
      revRec(x / 10); // doesn't return a value!!!!
    }
    
    //System.out.println();
    //return;
    
  }
  
//---------------------------------------------
  
  /* factRec() takes an integer x and returns x!,
   * using recursion
   */
  public static int factRec(int x) {
    int result=0;
    
    if (x == 0) { // base case
      result = 1;
    } else { // recursive case
      result = x * factRec(x - 1);
    }

    return result;
  } // End factRec() 
  
//--------------------------------------------------
  
  /* sumRec() takes an integer x and returns the sum
   * 1+2+3..n, using recursion.
   */
  public static int sumRec(int x) {
    int result=0;
    
    if (x == 0) { // base case
      result = 0;
    } else { // recursive case
      result = x + sumRec(x - 1);
    }
    
    return result;
  } // End sumToRec()
  
  //---------------------------------
  
  /* multRec() takes two integers x and y, and returns 
   * x*y, using recursion
   */
  public static int multRec(int x, int y) {
    int result=1;
    
    if (y == 0) { // base case
      result = 0;
    } else { // recursive case
      result = x + multRec(x, y - 1);
    }
    
    return result;
  } // End multRec()
  
  //---------------------------------
  
  /* powRec() takes integers x and n and returns
   * x^n using recursion.
   */ 
  public static int powRec(int x, int n) {
    int result=1;
    
    if (n == 0) { // base case
      result = 1;
    } else { // recursive case
      result = x * powRec(x, n - 1);
    }

    return result;
  } // End powerRec()
  
//---------------------------------
  
  /* divRec() takes two integers x and y, and returns 
   * x/y (integer division), using recursion
   */ 
  public static int divRec(int x, int y) {
    int result = 0;
    
    if (x < y) { // base case
      result = 0;
    } else { // recursive case
      result = 1 + divRec(x - y, y);
    }
    
    return result;
  }
  
  //---------------------------------
  
  /* modRec() takes integers x and y and returns
   * x%y using recursion
   */ 
  public static int modRec(int x, int y) {
    int result=0;
    
    if (x < y) { // base case
      result = x;
    } else { // recursive case
      result = modRec(x - y, y);
    }
    
    return result;
  } // End modRec()
  
  /* nthFibRec() takes an integer x and returns the xth
   * Fibonacci number. For example, nthFibRec(7)==>13
   */
  public static int nthFibRec(int x) {
    int result=0;
    
    if (x == 0) { // base case 1
      result = 0;
    } else if (x == 1) { // base case 2
      result = 1;
    } else { // recursive case
      result = nthFibRec(x - 1) + nthFibRec(x - 2);
    }
    
    return result;
  } // end nthFibRec()
  
  //---------------------------------
  
  /* numDigitsRec() takes an integer x and returns
   * the number of digits in x using recursion.
   */
  public static int numDigitsRec(int x) {
    int result=0;
    
    //int result=0;
    
    if (x < 10) { // base case
      result = 1;
    } else { // recursive case
      result = 1 + numDigitsRec(x/10);
    }

    return result;
  } // End numDigitsRec()
  
//---------------------------------
  
  /* sumDigitsRec() takes an integer x and returns
   * the sum of the digits in x using recursion.
   * Note: Doesn't have to handle 0.
   */ 
  public static int sumDigitsRec(int x) {
    int result=0;
    
    if (x < 10) { // base case
      result = x % 10;
    } else { // recursive case
      result = x % 10 + sumDigitsRec(x/10);
    }
    
    return result;
  } // End sumDigitsRec()
  
//---------------------------------
  
  public static int gcdRec(int x, int y) {
    int result = 0;
    
    // Using Eculid's Algorithm    
    if (y == 0) { // base case
      result = x;
    } else {
      result = gcdRec(y, x % y); // recursive case
    }

    return result;
  }
  
  //---------------------------------
  
  public static int gcdRec3(int x, int y, int z) {
    int result = 0;
    
    result = gcdRec(x, gcdRec(y, z));
    
    return result;
  }
  
  //---------------------------------
  
  public static int chooseRec(int x, int y) {
    int result = 0;
    
    if (x == y | y == 0) { // base case 1
      result = 1;
    } else if (y == 1) { // base case 2
      result = x;
    } else if (y > x | y <= 0) { // base case 3
      result = 0;
    } else {
      result = chooseRec(x - 1, y - 1) + chooseRec(x - 1, y); // recursive call
    }

    return result;
  }
  
  //---------------------------------
  
  /* hanoiRec() takes a number of disks, the number of the peg
   * that the disks start on, the number of the peg that can
   * be used temporarily, and the number of the peg that they
   * should end on, and it prints out the instructions on how to
   * solve the puzzle.
   */ 
  
  // from peg, temp peg, to peg
  // Move a disk from 2 to 1
  
  public static void hanoiRec(int disks, int from, int using, int to) {
    if (disks == 1) { // base case
      System.out.println("Move a disk from " + from + " to " + to + ".");
    } else {
      hanoiRec(disks - 1, from, to, using); // recursive step 1
      System.out.println("Move a disk from " + from + " to " + to + ".");
      hanoiRec(disks - 1, using, from, to); // recursive step 2
    }

  } // end hanoiRec
  
//---------------------------------
//---------------------------------
  
} // end class h6