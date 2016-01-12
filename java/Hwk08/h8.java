// =============
// Homework 08
// Chris Fenton
// 1/12/2016
// =============

public class h8 {

  public static void main(String args[]) {
    h8t.isMember();
    h8t.subArray();
    h8t.union();
    h8t.intersection();
    h8t.isPalSub();
  }
  // isMember() takes an int a and an array x and returns
  // true if a is found in x and false if it is not found
  public static boolean isMember(int[] x, int a) {
    // loop through x
    // check if each value = a
    // if a is found, set result to true

    boolean result = false;

    for(int i=0;i<=x.length+1;i++) {
      if(x[i] == a) return true;
    }

    return result;
  }

  public static int[] subArray(int[] x, int start, int end) {

    int[] result={};

    return result;
  }

  public static int[] union(int[] x, int[] y) {
    int[] result = {};
    return result;
  }

  public static int[] intersection(int[] x, int[] y) {
    int[] result={};
    return result;
  }

  public static boolean isPalSub(int[] x) {
    boolean result = false;

    return result;
  }


  //=================================================
  // Helper Methods
  //=================================================

  // Helper for isPalSub
  public static boolean isPal(int[] x) {
    boolean result = true;

    return result;
  }

  /* clone() returns a copy of an integer array
   * Paramaters: x, the array to be cloned
   * Returns: An array that contains the same integers as x
   */
  public static int[] clone(int[] x) {

    int[] result;
    int lp=0, len = x.length;

    result = new int[len];

    for(lp=0;(lp<len);lp++) {
      result[lp]=x[lp];
    } // end for

    return result;

  } // end clone()

  //=================================================
} // end class hwk8


