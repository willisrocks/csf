import java.util.*;

class TM {
  
  public static void main(String args[]) {
    String[] instructions = {"x01Rx", "y10Rx"};
    String initialTape = " 010 ";
    ArrayList<Character> states = Control.getStates(instructions);
    char[] tape = initialTape.toCharArray();
    int head = 1;
    ArrayList<Transition> transitions = Control.getTransitions(instructions);
    ArrayList<State> stateObjects = Control.setStates(states, transitions);
    State currentState = stateObjects.get(0);
    Transition nextTrans = currentState.findTransition(String.valueOf(initialTape.charAt(head)));
    
    //System.out.println("Tape:");
    //System.out.println(tape);
    //System.out.println("Instructions:");
    //printArray(instructions);
    //System.out.println("States:");
    //System.out.println(states);
    //System.out.println("Transitions:");
    //System.out.println(transitions);
    //System.out.println(stateObjects);
    System.out.println(nextTrans);
    
    // To do: abstract out Tape into its own class
  }
  
  public static void printArray(String arr[]) {
    for (int i=0; i<arr.length; i++) {
      System.out.println(arr[i]);
    }
  }
  
} // end TM class