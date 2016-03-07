import java.util.*;

public class State {
  private String name;
  private ArrayList<Transition> transitions;
  
  public State (String name, ArrayList<Transition> transitions) {
    this.name = name;
    this.transitions = transitions;
  }
  
  public State (char name, ArrayList<Transition> transitions) {
    this.name = String.valueOf(name);
    this.transitions = transitions;
  }
  
  public Transition findTransition (String cell) {
    Transition result = new Transition();
    
    for (Transition t : transitions) {
      if (t.getCurrentVal().equals(cell)) { return t; }
    }
    
    return result;
  }
  
  public String getName() {
    return name;
  }
  
  public String toString() {
    return "{" + name + ", Transitions: " + transitions + "}";
  }
  
} // end State class