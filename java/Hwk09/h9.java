//=================================================
// -------------- Homework 09 ---------------------
// -------------- Chris Fenton --------------------
// -------------- 1/18/2016 -----------------------
//=================================================

public class h9 {
  
  // ==================================================
  // detectMagic() takes a 2 dimensional array x
  // and returns a boolean indicating if x
  // is a magic square
  // ==================================================
  
  public static boolean detectMagic(int[][] x) {
    boolean result = true;
    
    // exit early if x isn't a square
    if (!(isSquare(x))) {
      System.out.println(isSquare(x));
      return false;
    }
    
    // exit early if x doesn't contain 1 : n^2
    if (!(isConsecutive(x))) {
      return false;
    }
    
    // get sum of rows, columns, and diags
    int[] diags = sumDiagonals(x);
    int[] rows = sumRows(x);
    int[] cols = sumColumns(x);
    int[][] sums = {diags, rows, cols};
    int test = diags[0]; // test any number agains the others
    
    // check that the sums match the magic number
    for (int i = 0; i < sums.length; i++) {
      for (int j = 0; j < sums[i].length; j++) {
        // exit early if a sum doesn't match
        if (sums[i][j] != test) return false;
      }
    }
    
    return result;
  } // end detectMagic()
  
  // ==================================================
  // makeMagic() takes an odd integer n
  // and returns a 2 dimensional array representing
  // the magic square
  // ==================================================
  
  public static int[][] makeMagic(int n) {
    int[][] square = new int[n][n];
    int mid = n / 2;
    int y = 0, x = mid;
    
    // ensure odd n
    if (n % 2 == 0) {
      throw new RuntimeException("Square must be odd");
    }
    
    // put 1 in the middle of the top row
    square[y][x] = 1;
    
    for (int i=2; i <= (n*n); i++) {
      int new_y = y;
      int new_x = x;
      // find diag pos
      new_y = wrap(y-1,0,n-1);
      new_x = wrap(x+1,0,n-1);
      // check to see if new pos is taken
      if (square[new_y][new_x] != 0) {
        new_y = wrap(y+1,0,n-1);
        new_x = x;
      }
      // place number
      y = new_y;
      x = new_x;
      square[y][x] = i;
    }
    
    return square;
  } // end makeMagic()
  
  // ==================================================
  // makeMagic4() takes an doubly even n
  // and returns a 2 dimensional array representing
  // the magic square
  // ==================================================
  
  public static int[][] makeMagic4(int n) {
    int[][] square = new int[n][n];
    int diag_size = n / 4;
    int mid_size = diag_size * 2;
    int[] numbers = new int[n*n];
    int num_cnt = 0;
    
    // ensure multiples of 4
    if (n % 4 != 0) {
      throw new RuntimeException("Square must be doubly even");
    }
    
    // find corner and middle box coords
    int[][] top_left = buildBox(diag_size, 0, 0, 0, diag_size - 1);
    int[][] top_right = buildBox(diag_size, 0, n - diag_size, n - diag_size, n - 1);
    int[][] bot_left = buildBox(diag_size, n - diag_size, 0, 0, diag_size - 1);
    int[][] bot_right = buildBox(diag_size, n - diag_size, n - diag_size, n - diag_size, n - 1);
    int[][] middle = buildBox(mid_size, diag_size, diag_size, diag_size, n - diag_size - 1);
    
    // loop through box arrays and mark the square with -1
    for (int i = 0; i < top_left.length; i++) {
      square[top_left[i][0]][top_left[i][1]] = -1;
    }
    for (int i = 0; i < top_right.length; i++) {
      square[top_right[i][0]][top_right[i][1]] = -1;
    }
    for (int i = 0; i < bot_left.length; i++) {
      square[bot_left[i][0]][bot_left[i][1]] = -1;
    }
    for (int i = 0; i < bot_right.length; i++) {
      square[bot_right[i][0]][bot_right[i][1]] = -1;
    }
    for (int i = 0; i < middle.length; i++) {
      square[middle[i][0]][middle[i][1]] = -1;
    }
    
    // fill numbers array with 1 : n^2
    for (int i=0; i < numbers.length; i++) {
      numbers[i] = i + 1;
    }
        
    // loop through square and update marked squares
    for (int i = 0; i < square.length; i++) {
      for (int j = 0; j < square[i].length; j++) {
        if (square[i][j] == -1) {
          square[i][j] = numbers[num_cnt];
          numbers[num_cnt] = 0;
        }
        num_cnt++;
      }
    }
    
    // sort numbers array in desc order
    insertSortDesc(numbers);
    num_cnt = 0;
    
    // loop through square and update empty squares
    for (int i = 0; i < square.length; i++) {
      for (int j = 0; j < square[i].length; j++) {
        if (square[i][j] == 0) {
          square[i][j] = numbers[num_cnt];
          num_cnt++;
        }
        
      }
    }
    
    //printArray(numbers);
    
    return square;
  } // end makeMagic4()
  
  
  // ==================================================
  // Helper Methods
  // ==================================================
  
  // ==================================================
  // make() takes 4 integers x, y, smallest, and 
  // largest and returns a 2 dimensional array with 
  // y columns and x rows filled with random integers
  // between smallest and largest
  // ==================================================
  
  public static int[][] make(int y, int x, int smallest, int largest) {
    int[][] result;
    int value = 0, lpy = 0, lpx = 0;
    
    result = new int[y][x];
    
    for (lpy=0;lpy<y;lpy++) {
      for(lpx=0;lpx<x;lpx++) {
        value = myRand(smallest, largest);
        result[lpy][lpx] = value;
      } // end inner x loop
    } // end outer y loop
    
    return result;
  } // end make()
  
  // ==================================================
  // myRand() takes 2 integers low and high and returns
  // a random integer between those 2 numbers
  // ==================================================
  
  public static int myRand(int low, int high) {
    int rand=0;
    
    rand=((int)((Math.random()*(high-low+1))+low));
    
    return rand;
  } // end myRand()
  
  // ==================================================
  // printGrid() takes a 2 dimensional array x
  // and prints each row on a new line
  // ==================================================
  
  public static void printGrid(int[][] x) {
    for (int i=0;i<=x.length-1;i++) {
      printArray(x[i]);
      System.out.println("\n");
    }
  } // end printGrid()
  
  // ==================================================
  // printArray() takes an array x and prints
  // each element with a tab seperator
  // ==================================================
  
  public static void printArray(int[] x) {
    for (int i=0;i<=x.length-1;i++) {
      System.out.print(x[i] + "\t");
    }
  } // end printArray()
  
  // ==================================================
  // isSquare() takes a 2d array
  // and returns a boolean indicating if 
  // the array is a square.
  // ==================================================
  
  public static boolean isSquare(int[][] x) {
    boolean result = true;
    
    for (int i=0; i < x.length; i++) {
      if (x.length != x[i].length) return false;
    }
    
    return result;
  } // end isSquare()
  
  // ==================================================
  // sumDiagonals() takes a 2 dimensional array
  // and returns an integer with the sum of each
  // diagonal row
  // ==================================================
  
  public static int[] sumDiagonals(int[][] x) {
    int[] result = {0,0};
    
    for (int i=0; i < x.length; i++) {
      result[0] += x[i][i];
      result[1] += x[x.length - 1 - i][i];
    }
    
    return result;
  } // end sumDiagonals()
  
  // ==================================================
  // sumRows() takes a 2d array
  // and returns an array with 
  // the sum of the rows
  // ==================================================
  
  public static int[] sumRows(int[][] x) {
    int[] result = new int[x.length];
    
    for (int j=0; j < result.length; j++) {
      
      for (int i=0; i < x[j].length; i++) {
        result[j] += x[j][i];
      }
    }
    
    return result;
  } // end sumRows()
  
  // ==================================================
  // sumColumns() takes an 2d array
  // and returns and array with the sum of 
  // each column
  // ==================================================
  
  public static int[] sumColumns(int[][] x) {
    int[] result = new int[x[0].length];
    
    for (int j=0; j < result.length; j++) {
      
      for (int i=0; i < x.length; i++) {
        result[j] += x[i][j];
      }
    }
  
    return result;
  } // end sumColumns()
  
  // ==================================================
  // isConsecutive() takes an 2d array
  // and returns and a boolean to indicate 
  // if each item in the arrays is order
  // ==================================================
  
  public static boolean isConsecutive(int[][] x) {
    boolean results = true;
    
    // assume square
    int len = x.length * x[0].length;
    int[] flat = clone(x[0]);
    
    for (int i=1; i < x.length; i++) {
      flat = concat(x[i], flat);
    }
    
    insertSort(flat);
    
    // check flat array for consecutive numbers
    for (int i=0; i < flat.length; i++) {
      if (flat[i] != (i + 1)) return false;
    }
    
    return results;
  } // end isConsecutive()
  
  
  // ==================================================
  // insertSort() takes an array
  // and sorts it using the insertion sort 
  // algorithm. we covered this in discrete math
  // ==================================================
  
  public static void insertSort (int[] a) {
    for (int i=1; i < a.length; i++) {
      int temp = a[i];
      int j;
      for (j = i - 1; j >= 0 && temp < a[j]; j--) {
        a[j+1] = a[j];
      }
      a[j+1] = temp;
    }
  } // end insertSort()
  
  // ==================================================
  // insertSortDesc() takes an array
  // and sorts it in descending order using the 
  // insertion sort algorithm
  // ==================================================
  
  public static void insertSortDesc (int[] a) {
    for (int i=1; i < a.length; i++) {
      int temp = a[i];
      int j;
      for (j = i - 1; j >= 0 && temp > a[j]; j--) {
        a[j+1] = a[j];
      }
      a[j+1] = temp;
    }
  } // end insertSortDesc()
  
  // ==================================================
  // clone() returns a copy of an integer array
  // Paramaters: x, the array to be cloned
  // Returns: An array that contains the same 
  // integers as x
  // ==================================================
  
  public static int[] clone(int[] x) {

    int[] result;
    int lp=0, len = x.length;

    result = new int[len];

    for(lp=0;(lp<len);lp++) {
      result[lp]=x[lp];
    } // end for

    return result;
  } // end clone()
  
  // ==================================================
  // concat() returns the concatanation of 2 arrays
  // Paramaters: x and y, the arrays to be concatanated
  // Returns: An array that contains the concat of 
  // x and y
  // ==================================================
  
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
  
  // ==================================================
  // wrap() returns an integer that wraps around
  // columns and rows in a magic square
  // ==================================================
  
  public static int wrap(int x, int start, int end) {
    if (x < start) x = end;
    if (x > end) x = start;
    return x;
  } // end wrap()
  
  // ==================================================
  // buildBox() returns an array with the coordinates
  // of a small box in a magic square
  // ==================================================
  
  public static int[][] buildBox(int n, int y, int x, int start, int end) {
    int[][] results = new int[n*n][2];
    
    for (int i=0; i < results.length; i++) {
      if (i % n == 0 && i > 0) y++;
      results[i][0] = y;
      results[i][1] = x;
      x = wrap(x+1,start,end);
    }
    
    return results;
  } // end buildBox()
      
} // end h9 class
