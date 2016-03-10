import java.util.*;
import java.io.*;

class Turing {
  
  /**
   * File: Turing.java
   * Author: Chris Fenton
   * Last Modified: 03/09/16
   * Command Line: java Turing myTuringMachineProgram.txt [optional: override initial tape]
   * 
   * Description: Command line turing machine simulator
   * 
   * Program File Structure: 
   * 
   * Plain text file read by lines
   * ignoring lines beginning with '#' character. Expects
   * the first line to be a string of the initial tape.
   * Expects the second line to be the one letter string 
   * representing the initial state. Expects the third line
   * to be the one letter string representing the halting
   * state. Lines four to the end of the file contain the
   * program in the form of S R W D NS with no spaces where
   * S = starting state
   * R = value read
   * W = value written
   * D = direction (L or R)
   * NS = next state
   * 
   * See included program files for an example
   */
  
  public static void main(String args[]) { 
    
    // read program file
    
    String[] instructions = null;
    List<String> programInputLines = new ArrayList<String>();
    String initialState = "";
    String haltingState = "";
    String initialTape = "";
    String programFile = "";

    try 
    { 
        
      programFile = args[0];
     
      FileInputStream fstream_instructions = new FileInputStream(programFile); 
      DataInputStream data_input = new DataInputStream(fstream_instructions); 
      BufferedReader buffer = new BufferedReader(new InputStreamReader(data_input)); 
      String str_line; 
      
      while ( ( str_line = buffer.readLine() ) != null) 
      { 
        str_line = str_line.trim();
        
        if ( (str_line.length()!=0) && (str_line.charAt(0) != '#') )  
        {  
          programInputLines.add(str_line);
        } 
      }
      
      // set TM variables
      if (args.length > 1) {
        initialTape = args[1]; // override initialTape
      } else {
        initialTape = programInputLines.get(0);
      }
      initialState = programInputLines.get(1);
      haltingState = programInputLines.get(2);
      programInputLines = programInputLines.subList(3, programInputLines.size() -1);
      instructions = (String[])programInputLines.toArray(new String[programInputLines.size()]);  
      
    }
    catch (Exception e)  
    {
      // Catch exception if any
      System.err.println("Error: " + e.getMessage());
    }     
    
    // Create and run Turing machine
    
    TM tm = new TM(instructions, initialTape, initialState, haltingState);
    Tape tape = tm.getTape();
    
    System.out.println("Initial Tape:");
    tape.getTapeContents(false);
    
    tm.run();
    
    System.out.println("Ending Tape:");
    tape.getTapeContents(false);  
    
  }
  
} // end Turing class