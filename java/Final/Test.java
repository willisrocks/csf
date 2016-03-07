import java.util.*;

class Test {
  
  public static void main(String args[]) {
    String[] instructions = {"s**Rx", // starting state
                             "x01Rx", // see 0, write 1
                             "x10Rx", // see 1, write 0
                             "x***h", // halting state
                             "h****"};
    String initialTape = "1010";
    
    TM tm = new TM(instructions, initialTape, "s", "h");
    Tape tape = tm.getTape();
    tape.getTapeContents();
    System.out.println(tm.getStartingState());
    System.out.println(tm.getHaltingState());
    
    
    // To do: TM:step()
  }
  
  public static void printArray(String arr[]) {
    for (int i=0; i<arr.length; i++) {
      System.out.println(arr[i]);
    }
  }
  
} // end Test class