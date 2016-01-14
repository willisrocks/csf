public class h9 {
  // ======================================
  // Helper Methods
  // ======================================
  
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
    
  }
  
  public static int myRand(int low, int high) {
    int rand=0;
    
    rand=((int)((Math.random()*(high-low+1))+low));
    
    return rand;
    
  } // end myRand()
  
  public static void printGrid(int[][] x) {
    for (int i=0;i<=x.length-1;i++) {
      printArray(x[i]);
      System.out.println("\n");
    }
  }
  
  public static void printArray(int[] x) {
    for (int i=0;i<=x.length-1;i++) {
      System.out.print(x[i] + "\t");
    }
  }
  
}
