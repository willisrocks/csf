import java.util.*;

class Test {
  
  public static void main(String args[]) {
    String[] instructions = {"s**Rx", // starting state
                             "x01Rx", // see 0, write 1
                             "x10Rx", // see 1, write 0
                             "x***h", // halting state
                             "h****"};
    String initialTape = "00000000000";
    
    TM tm = new TM(instructions, initialTape, "s", "h");
    Tape tape = tm.getTape();
    //tape.getTapeContents();
    //System.out.println(tm.getStartingState());
    //System.out.println(tm.getHaltingState());
    System.out.println("Initial Tape:");
    tape.getTapeContents();
    
//    System.out.println("Step 1:");
//    tm.step();
//    tape.getTapeContents();
//    
//    System.out.println("Step 2:");
//    tm.step();
//    tape.getTapeContents();
//    
//    System.out.println("Step 3:");
//    tm.step();
//    tape.getTapeContents();
//    
//    System.out.println("Step 4:");
//    tm.step();
//    tape.getTapeContents();
//    
//    System.out.println("Step 5:");
//    tm.step();
//    tape.getTapeContents();
//    
//    System.out.println("Step 6:");
//    tm.step();
//    tape.getTapeContents();
//    
//    
//    
//    System.out.println(tm.getCurrentState());
    
    tm.run();
    tape.getTapeContents();
    
    tape.rewindHead();
    
    tape.addCellRight();
    tape.getTapeContents();
    
    tape.addCellLeft();
    tape.getTapeContents();
    
    tape.printIndexes();
    //tape.reIndex();
    //tape.printIndexes();
    
  }
  
  public static void printArray(String arr[]) {
    for (int i=0; i<arr.length; i++) {
      System.out.println(arr[i]);
    }
  }
  
} // end Test class