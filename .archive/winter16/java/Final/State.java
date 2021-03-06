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
  
  public Transition findTransition (char cv) {
    Transition result;

    for (Transition t : transitions) {
      if ( t.getCurrentVal() == cv ) { return t; }
    }
    
    return null;
  }
  
  public String getName() {
    return name;
  }  
  
  public String toString() {
    return "{" + name + ", Transitions: " + transitions + "}";
  }
  
} // end State class