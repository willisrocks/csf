import java.util.*;

class Test {
  
  public static void main(String args[]) {
    String[] complementInstructions = {"sBBRx", "x01Rx", "x10Rx", "xBBLh", "h****"};
    String[] incrementInstructions = {"aBBRb", "b00Rb", "b11Rb", "bBBLc", "c01Rh", "c10Lc", "cB1Lh", "h****"};
    String initialTape = "111010101011010110111100000";
    
    TM tm = new TM(complementInstructions, initialTape, "s", "h");
    Tape tape = tm.getTape();
    
    System.out.println("Initial Tape:");
    tape.getTapeContents(false);
    
    tm.run();
    
    tape.getTapeContents(false);  
    
  }
  
} // end Test class