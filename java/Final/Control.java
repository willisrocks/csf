import java.util.*;
import java.lang.String;

public class Control {
  
  public static ArrayList<Character> getStates(String[] instr) {
    ArrayList<Character> states = new ArrayList<Character>();
    for (int i=0; i < instr.length; i++) {
      if (!states.contains(instr[i].charAt(0))) {
        states.add(instr[i].charAt(0));
      }
    }    
    
    return states;
  }
  
  public static ArrayList<Transition> getTransitions (String[] instr) {
    ArrayList<Transition> transitions = new ArrayList<Transition>();
    for (int i = 0; i < instr.length; i++) {
      instr[i] = instr[i].replaceAll("B", " "); // replace blanks
      Transition t = new Transition(instr[i].charAt(0), // cs
                                    instr[i].charAt(1), // cv
                                    instr[i].charAt(4), // ns
                                    instr[i].charAt(2), // nv
                                    instr[i].charAt(3)  // dir
                                    );
      transitions.add(t);   
    }
    
    return transitions;
  }
  
  public static ArrayList<State> setStates (ArrayList<Character> s, ArrayList<Transition> t) {
    ArrayList<State> states = new ArrayList<State>();
    for (Character state: s) {
      ArrayList<Transition> tempTrans = new ArrayList<Transition>();
      for (Transition trans: t) {
        if ( trans.getCurrentState() == state ) {
          tempTrans.add(trans);
        }
      }
      State newState = new State(state, tempTrans);
      states.add(newState);
    }
    return states;
  }
  
  public static State findState(ArrayList<State> states, String s) {
    for (State state: states) {
      if(state.getName().equals(s)) { return state; }
    }
    return null;
  }
  
} // end Control class