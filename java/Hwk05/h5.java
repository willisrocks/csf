/*
 *  File:           h5.java
 *  Author:         Chris Fenton
 *  Last modified:  10/27/2015
 * 
 *  This class contains mathemtical functions built
 *  entirely from the increment and decrement
 *  operators.
 */

//==================================================

public class h5 {
  
//==================================================
  
 // ALL OF YOUR CODE GOES HERE!
  
//==================================================
  
//==================================================
// Write a method myAdd() that takes two integers and 
// returns an integer. It should return the sum of 
// the two integers.  
//==================================================
  public static int myAdd(int x, int y) {
    int result = 0;
    
    // taking off the seatbelt: declaring my counter
    // in the for loop. restricting the scope lets
    // quickly code a for loop without having to
    // worry about the counter variable's scope
    // and reuse a simple variable name like 'i'
    // in multiple for loops like below
    
    // increment result x times
    for (int i=1;i<=x;i++) { 
      result++;
    }
    // increment results y times
    for (int i=1;i<=y;i++) { 
      result++;
    }
    
    return result;
  } // end myAdd()
  
//==================================================
// Write a method mySub() that takes two integers and 
// returns an integer. It should return the 
// difference of the two integers. Note that if the 
// second number is greater than the first, then 
// the result is 0.
//==================================================
  public static int mySub(int x, int y) {
    int result = 0;
    
    if (x > y) {
      result = x;
      // decrement result y times
      for (int i=1;i<=y;i++) {
        result--;
      }
    }
     
    return result;
  } // end mySub()
  
//==================================================
// Write a method myMult() that takes two integers 
// and returns an integer. It should return the 
// multiplication of the two integers.
//==================================================
  public static int myMult(int x, int y) {
    int result = 0;
    
    // add x to result y times
    for (int i=1;i<=y;i++) {
      result = myAdd(x, result);      
    }
    
    return result;
  } // end myMult()
  
//==================================================
// Write a method myPow() that takes two integers 
// and returns an integer. It should return the 
// first number raised to the power of the second 
// number. Note that we will declare 00 to be 1.
//==================================================
  public static int myPow(int x, int n) {
    int result = 1;
    
    // x * x n times
    for (int i=1;i<=n;i++) {
      result = myMult(result, x);
    }
    
    return result;
  } // end myPow()
  
//==================================================
// Write method myFact() that takes an integer and 
// returns an integer. It should return the 
// factorial of the number given. Note that 
// myFact(0) returns 1.
//==================================================
  public static int myFact(int n) {
    int result = 1;
    
    // n! = n x (n -1)
    for (int i=n;i>=1;i--) {
      result = myMult(result, i);
    }
    
    return result;
  } // end myFact()
  
//==================================================
// Write method mySqrt() that takes an integer and 
// returns an integer. It should return the 
// �integer� sqrt of the number, that is, the 
// closest integer whose square it not greater than 
// the given integer.
//==================================================
  public static int mySqrt(int x) {
    int result = 0;
    
    // check if i*i <= 10 x times
    for (int i=1;i<=x;i++) {
      if (myMult(i, i) <= x) {
        result = i;
      }
    }
    
    return result;
  } // end mySqrt()
  
//==================================================
// Write a method myDiv() that takes two integers 
// and returns an integer. It should return the 
// integer division of the two integers. Assume 
// that it is not asked to divide by 0.
//==================================================
  public static int myDiv(int x, int y) {
    int result = 0;
    
    // instead of borrowing and subtracting
    // let's just see what the biggest multiple
    // of y that's less than or equal to x
    for (int i=1;i<=x;i++) {
      if (myMult(i, y) <= x) {
        result = i;
      }
    }
    
    return result;
  } // end myDiv()
  

//==================================================
// Write a method myMod() that takes two integers 
// and returns an integer. It should return the 
// modulo function of the two integers. Assume that 
// it is not asked to modulo by 0. Hint: You don't 
// need any loops for this one! mySub, myMult, and 
// myDiv may be useful!
//==================================================
  public static int myMod(int a, int n) {
    int result = 0;
    int quot = 0;
    
    // integer division is handy!
    quot = myDiv(a, n);
    
    // just the remainder remains
    result = a - myMult(n, quot);
    
    return result;
  } // end myMod()
  
//==================================================
// Write a method myChoose() that takes two integers 
// and returns an integer. It should return the 
// choose function, where 
// choose(a,b) = (a! / (b! * (a-b)!)). You don't 
// need any loops.
//==================================================
  public static int myChoose(int a, int b) {
    int result = 0;
    
    // time to put our factorial function to good use!
    result = (myFact(a) / (myFact(b) * myFact(a - b)));
    
    return result;
  } // end myChoose()
  
//==================================================
// Write method isPrime() that takes an integer and 
// returns a boolean, indicating whether or not the 
// given number is prime. Use mySqrt() to make the 
// function efficient.
//==================================================
  public static boolean isPrime(int x) {
    boolean result = true;
    
    // primes must be larger than 1 and 2 is
    // the only even prime
    if (x <= 1 || (x % 2 == 0 && (x > 2))) {
      result = false;
    } else {
      // we only have to check for odd divisors
      // from 3 to the sqaure root of x
      for (int i=3;i<=mySqrt(x)&&result;i+=2) {
        // if x has a divisor, it's not prime
        if (myMod(x, i) == 0) {
          result = false;
        }
      } // end for loop
    } // end else
    
    return result;
  } // end isPrime()
  
  
} // end class h5