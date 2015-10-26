// HWK4 Extra, Extra Credit Problems
class h4ec {
  
  // helper methods
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
  
} // end h4ec class