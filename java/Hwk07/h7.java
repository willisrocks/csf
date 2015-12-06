/*
 *  File:           h7.java
 *  Author:         Chris Fenton
 *  Last modified:  12/6/2015
 * 
 *  This class contains methods that work with
 * arrays.
 */

//---------------------------------------------

public class h7 {
  
  //---------------------------------------------
  
  public static int max(int[] x) {
    int max=0,i=0;
    
    max = x[0];
    for (i=0;(i<x.length);i++) {
      if (x[i]>max) {
        max = x[i];
      } // end if
    } // end for
    return max;
  } // end max()
  
  // --------------------------------------------------
  
  public static boolean equal(int[] x, int[] y) {
    boolean eq = true;
    int i = 0;
    
    if (x.length!=y.length) {
      eq = false;
    }
    else {
      
      for (i=0;(i<x.length);i++) {
        if (x[i]!=y[i]) {
          eq = false;
        } // end if
      } // end for
    }
    return eq;
  } // end max()
  
// --------------------------------------------------
  
  public static double mean(int[] x) {
    double result = 0;
    
    for (int i = 0; i <= x.length - 1; i++) {
      result += x[i];
    }
    System.out.println(result);
    result = result / x.length;
    
    return result;
  } // end mean()
  
// --------------------------------------------------
  
  public static void test (int x) {
    System.out.println(x);
    test1(x);
    System.out.println(x);
  }
  
  public static void test1 (int x) {
    System.out.println(x);
    x=x+1;
    System.out.println(x);
  }
  
// --------------------------------------------------
  
  public static void atest (int[] x) {
    print(x);
    atest1(x);
    print(x);
  }
  
  public static void atest1 (int[] y) {
    print(y);
    y[0]=y[0]+1;
    print(y);
  }
  
  // --------------------------------------------------
  // --------------------------------------------------
  
  
  public static boolean isSorted(int[] x) {
    boolean result=false, flag=true;
    
    for (int i =1; i <= x.length - 1; i++) {
      if (x[i-1] > x[i]) {
        flag = false; // I would prefer to be hacky and return false here to save time
      }
    }
    
    result = flag;
    return result;
  } // end isSorted()
  
  public static void replace(int[] x,int s, int r) {
    
    for (int i = 0; i <= x.length - 1; i++) {
      if (x[i] == s) {
        x[i] = r;
      }
    }
    
  } // end replace()
  
  public static int median(int[] x) {
    int result = 0, median = 0;
    int[] data = h7.clone(x);
    
    h7.sort(data);
    median = ((data.length + 1) / 2) - 1; // minus one on the end because we start at 0
    result = data[median];
    
    return result;
    
  } // end median()
  
  
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
  
  public static int[] rotateR(int[] x, int n) {
    int[] result={};
    result = new int[x.length];
    int[] begin = new int[n];
    int[] end = new int[x.length - n];
    
    // Fill begin array with the rotated items
    for (int i = 0; i < n; i++) {
      begin[i] = x[x.length - n + i];
    }
    
    // Fill end array with the non-rotated items
    for (int i = 0; i < x.length - n; i++) {
      end[i] = x[i];
    }
    
    result = concat(begin, end); // Combine the final array
    
    //print(begin);
    //print(end);
    
    return result;
  } // end rotateR()
  
  
  public static int mode(int[] x) {
    // clone
    // sort
    // count items
    // find max count
    // return max number
    
    int[] data = clone(x);
    int[] uniques = unique(data);
    int[] counts = {};
    int result = 0, max = 0;
    
        
    sort(data);
    counts = new int[uniques.length];
    
    for (int i = 0; i <= counts.length - 1; i++) {
      for (int j = 0; j <= data.length - 1; j++) {
        if (data[j] == uniques[i]) {
          counts[i]++;
        }
      }
    }
    
    max = (max(counts));
    
    for (int i = 0; i <= uniques.length - 1; i++) {
      if(counts[i] == max) {
        result = uniques[i];
        return result; // return early with the first mode
      }
    }
    
    return result;
  } // end mode()
  
  public static int[] unique(int[] array) {
    // returns a sorted copy of array with only the unique items
    int[] result={}, counts={};
    boolean[] unique_indexes = {};
    int[] x = clone(array);
    int unique_count = 0;
    
    sort(x);
    
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
  
  // --------------------------------------------------
  // --------------------------------------------------
  
  // HELPER METHODS
  
    
  /* make() creates a random integer array of arbitrary size
   * Paramaters: size, the size of the array
   *             smallest, the smallest value wanted
   *             largest, the largest value wanted
   * Returns: An integer array (address)
   */
  public static int[] make(int size,int smallest, int largest) {
    
    int[] result;
    int value=0,lp=0;
    
    result = new int[size];
    
    for(lp=0;lp<size;lp++) {
      value=myRand(smallest,largest);   
      result[lp]=value;
    } // end for
    
    return result;
    
  } // end make()
  
//-------
  
  public static int myRand(int low, int high) {
    int rand=0;
    
    rand=((int)((Math.random()*(high-low+1))+low));
    
    return rand;
    
  } // end myRand()
  
  //----------------------------------------------------------
  
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
  
  //----------------------------------------------------------  
  
  /* sort() sorts an array
   * Paramaters: x, the integer array to be sorted
   * Returns: void
   */
  public static void sort(int[] x) {
    
    java.util.Arrays.sort(x);
    
  } // end sort()
  
  //----------------------------------------------------------  
  
  /* print() prints out an integer array of arbitrary size
   * Paramaters: x, the integer array to be printed
   * Returns: void
   */
  public static void print(int[] x) {
    
    int lp=0;
    
    System.out.print("{ ");
    for(lp=0;lp<x.length-1;lp++) {
      System.out.print(x[lp]+", ");
    } // end for
    System.out.println(x[lp]+" }");
    
  } // end print()
  
  //================================================= 
} // end class hwk7


