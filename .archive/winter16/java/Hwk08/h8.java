//=================================================
// -------------- Homework 08 ---------------------
// -------------- Chris Fenton --------------------
// -------------- 1/12/2016 -----------------------
//=================================================

public class h8 {

  // main() is the main method for this class
  // and is what's run when running this file
  // on the command line with java.
  // main() calls testAll() to print out the
  // test cases for this lab
  public static void main(String[] args) {
    test();
  }

  // testAll() calls each method test for this
  // lab and prints the result for each test
  public static void test() {
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

    for(int i=0;i<=x.length-1;i++) {
      if(x[i] == a) return true;
    }

    return result;
  }

  // subArray() takes and int array and 2 ints start and end
  // and returns a sub array containing the values for x
  // starting at start and ending at end
  public static int[] subArray(int[] x, int start, int end) {
    // create new results array
    // loop through x from start to end
    // assign values from x to results

    int len = 0;
    // check that end is larger than start
    // if not, leave len at 0
    if (end >= start) {
      len = end - start + 1;
    }
    int[] result = new int[len];

    for (int i=start;i<=end;i++) {
      result[i - start] = x[i];
    }

    return result;
  }

  // union takes 2 int arrays x and y and returns
  // an int array containing the set union of
  // x and y (sorted)
  public static int[] union(int[] x, int[] y) {
    // concat x and y
    // remove duplicates
    // sort result

    int[] result = concat(x, y);
    result = unique(result);
    mySort(result);

    return result;
  }

  // intersection() takes 2 int arrays x and y
  // and returns an int array containing the
  // intersection of x and y
  public static int[] intersection(int[] x, int[] y) {
    // find members of both arrays
    // loop through members array and increment len
    // create results array with length len
    // loop through members and assign trues to result
    // sort result array

    int[] result = {}, a = {}, b = {};
    boolean[] members = {};
    int len = 0, lp = 0;

    // work with unique values
    a = unique(clone(x));
    b = unique(clone(y));

    members = new boolean[a.length];

    // fill truth values for members array and
    // find length of result array
    for (int i=0;i<=a.length-1;i++) {
      if (isMember(b,a[i])) {
        members[i] = true;
        len++;
      } else {
        members[i] = false;
      }
    }

    result = new int[len];

    for (int i=0;i<=a.length-1;i++) {
      if (members[i]) {
        result[lp] = a[i];
        lp++;
      }
    }

    return result;
  }

  // isPalSub() takes an int array x and
  // returns true if any integer palindrome
  // of length >= 3 is found in x
  public static boolean isPalSub(int[] x) {

    for (int i=0;i<=x.length-1;i++) {
      for(int j=i+2;j<=x.length-1;j++) {
        if (isPal(subArray(x,i,j))) {
          return true;
        }
      }
    }

    return false;
  }


  //=================================================
  // Helper Methods
  //=================================================

  // Helper for isPalSub
  public static boolean isPal(int[] x) {
    int end = x.length - 1;

    if (x.length == 0 || x.length == 1) {
      return true;
    }
    if (x[0] == x[end]) {
      return isPal(subArray(x, 1, end - 1));
    }

    return false;
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

  /* concat() returns the concatanation of 2 arrays
   * Paramaters: x and y, the arrays to be concatanated
   * Returns: An array that contains the concat of x and y
   */
  public static int[] concat(int[] x, int[] y) {
    int[] result={};
    int x_len = 0, y_len = 0;

    x_len = x.length;
    y_len = y.length;
    result = new int[x_len + y_len];

    // add all the x values to the beginning of the new array
    for (int i = 0; i <= x_len - 1; i++) {
      result[i] = x[i];
    }

    // add all the y values to the end of the new array
    for (int j = 0; j <= y_len - 1; j++) {
      result[x_len + j] = y[j];
    }

    return result;
  } // end concat()

  // mySort() returns a in-place sorted array
  public static void mySort(int[] x) {
    int temp = 0, low = 0;

    for(int i = 0; i < x.length - 1; i++) {
      low = i;

      for(int j = i + 1; j < x.length; j++) {
        if(x[j] < x[low]) low = j;
      }

      // swap elements
      temp = x[low];
      x[low] = x[i];
      x[i] = temp;
    }
  } // end mysort()

  // unique() returns a sorted copy of array with only the unique items
  public static int[] unique(int[] array) {
    int[] result={}, counts={};
    boolean[] unique_indexes = {};
    int[] x = clone(array);
    int unique_count = 0;

    mySort(x);

    // Get the count of unique items
    if (x.length > 0) unique_count++;

    for (int i = 1; i <= x.length - 1; i++) {
      if(x[i-1] != x[i]) {
        unique_count++;
      }
    }

    // Create arrays with right amount of items
    result = new int[unique_count];
    counts = new int[unique_count];
    unique_indexes = new boolean[x.length];

    //result[0] = x[0]; // copy first item
    unique_indexes[0] = true;

    // Fill unique_indexes values
    for (int i = 1; i <= x.length - 1; i++) {
      if(x[i-1] != x[i]) {
        unique_indexes[i] = true;
      }
    }

    // Fill result array with unique values
    int j = 0; // result counter
    for (int i = 0; i <= unique_indexes.length - 1; i++) {
      if(unique_indexes[i] == true) {
        result[j] = x[i];
        j++;
      }
    }

    return result;
  } // end unique()


  //=================================================
} // end class hwk8


