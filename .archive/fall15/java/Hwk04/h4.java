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

  public static int abs(int x) {
    int result = 0;
    int a = x;
    int mask = (a >> 31); // mask

    result = a ^ mask; // x xor mask
    result = result - mask; // subtract mask (1 for negatives)

    return result;
  }
  public static int flip(int x) {
    int result = 0;
    int a = x;

    a = ~a; // compliment operator
    a++;    // add one

    result = a;

    return result;
  }
  public static int pow(int x, int n) { // raise x to the nth power
    int result = 1;
    for(int i = 1;i<=n;i++) {
      result = myMult(result,x);
    }
    return result;
  }
  // end helper methods

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

  /* areAmicable() takes two integers,  x and y, and determines
   * if they are amicable, returning an boolean.
   */
  public static boolean areAmicable(int x, int y) {
    boolean result = false;

    if(x != y) {
      if(sumPropDivisors(x) == y && sumPropDivisors(y) == x) {
        result = true;
      }
    }

    return result;
  }

//---------------------------------
  /* nthAmicable() takes an integer x (less than 8) and determines
   * the nth amicable pair, printing the first x amicable pairs to the console.
   * restricting x to integers below 8 just to prevent long execution times.
   * inspiration from https://www.youtube.com/watch?v=IbhBki25KGc and projectEuler.
   */
  public static void nthAmicable(int x) {
    assert x < 8 : "x is greater than 8";

    int start = 2;
    int i = 1;

    for(int n=start;i<=x;n++) {
      int newNum = sumPropDivisors(n);
      if (newNum <= n) { // jump ahead if newNum is less than n
        continue;
      }
      if(areAmicable(newNum,n)) {
        System.out.println(i + " " + n + "," + newNum);
        i += 1;
      }
    } // nthAmicable(2) returns 1 220, 284 and 2 1184,1210

  }
//---------------------------------



  // myMult() takes two integers the product of the two integers
  // by using only addition, returning an integer. Works with
  // signed integers
  public static int myMult(int x, int y) {
    int result = 0;
    boolean isNeg = false; // flag variable for keeping track of negative numbers
    int a = x;
    int b = y;

    if (a < 0 ^ b < 0) { // if a xor b is negative, the product is negative
      isNeg = true;
    }

    // get the absolute values of a and b to know what direction to loop
    a = abs(a);
    b = abs(b);

    // sum a b times
    for(int i=1;i<=b;i++) {
      result += a;
    }

    // if the product should be negative, flip the sign
    if (isNeg) {
      result = flip(result);
    }

    return result;
  }

  // myDiv() takes two non-negative integers the quotient of the two integers
  // without using the / operator, returning an integer. Works with
  // signed integers
  public static int myDiv(int x, int y) {
    int result = 0;
    boolean isNeg = false; // flag variable for keeping track of negative numbers
    int a = x;
    int b = y;
    int k = 0; //temp bucket for moving i in the loop
    int quot = 0; // temp bucket for holding the quotient in the loop

    if (a < 0 ^ b < 0) { // if a xor b is negative, the product is negative
      isNeg = true;
    }

    // get the absolute values of a and b to know what direction to loop
    a = abs(a);
    b = abs(b);

    quot = a;

    // subtract b from a n times
    for(int i=0;i<=quot;i=i+k) {
      if ((a - b) >= b) {
        k = b;
        quot = a - b;
        result++;
      } else {
        k = a - b;
      }

    }

    // if the product should be negative, flip the sign
    if (isNeg) {
      result = flip(result);
    }

    return result;
  }

  // intSqrt() takes an integers and returns the integer square root, returning an int
  // using Newton's method and using for loops in place of while loops
  public static int intSqrt(int x) {
    int result = 0;
    int n = abs(x); // the square root should be positive
    int xn = 1;
    int xn1 = (xn + n/xn) / 2;

    for (;xn1 - xn > 1;){
      xn = xn1;
      xn1 = (xn + n/xn)/2;
    }

    for (;myMult(xn1,xn1)>n;){
      xn1 -= 1;
    }

    result = xn1;


    return result;
  }

  // myPi() takes an integer n and finds an aproximation of PI to nth level of precision,
  // returning a double, where n indicates how many times to iterate the Leibniz formula
  public static double myPi(int x) {
    double result = 0.0;

    for (int i=1;i<x;i+=2) {
      result += (1.0 / (2.0 * i - 1)) - (1.0 / (2.0 * i + 1));
    }

    result = result * 4;

    return result;
  }


//==========================================

} // end class h4a
