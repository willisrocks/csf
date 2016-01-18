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
      return false;
    }
        
    // get sum of rows, columns, and diags
    int[] diags = sumDiagonals(x);
    int[] rows = sumRows(x);
    int[] cols = sumColumns(x);
    int[][] sums = {diags, rows, cols};
    int test = diags[0]; // test any number agains the others

    for (int i = 0; i < sums.length; i++) {
      for (int j = 0; j < sums[i].length; j++) {
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
    int[][] result = {{}};
    
    return result;
  } // end makeMagic()
  
  
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
  
    
    
} // end h9 class
