import java.util.*;

class TM {
  
  private Tape tape;
  private ArrayList<Character> states;
  private ArrayList<Transition> transitions;
  private ArrayList<State> stateObjects;
  private State startingState;
  private State haltingState;
  private State currentState;
  
  public TM(String[] instructions, String initialTape, String startingState, String haltingState) {
    this.tape = new Tape(initialTape);
    this.states = Control.getStates(instructions);
    this.transitions = Control.getTransitions(instructions);
    this.stateObjects = Control.setStates(states, transitions);
    this.startingState = Control.findState(stateObjects, startingState);
    this.haltingState = Control.findState(stateObjects, haltingState);
    this.currentState = this.startingState;
  }
  
  public Tape getTape() {
    return tape;
  }
  
  public String getStartingState() {
    return startingState.toString();
  }
  
  public String getHaltingState() {
    return haltingState.toString();
  }
  
  public void step() {
    //Transition rule = currentState.findTransition();
  }
  
} // end TM class