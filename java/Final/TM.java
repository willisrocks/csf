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
  
  public String getCurrentState() {
    return currentState.toString();
  }
  
  public void step() {
    Cell head = tape.getCurrentCell();
    Transition rule = currentState.findTransition(head.getContent());
    
    if (head.getContent() == rule.getCurrentVal()) {
      head.setContent( rule.getNewVal() );
      if (rule.getDir() == 'R') {
        tape.moveRight();
      } 
      if (rule.getDir() == 'L') {
        tape.moveLeft();
      }
      currentState = Control.findState( stateObjects, String.valueOf(rule.getNewState()) );
    }
  }
  
  public void run() {
    while(currentState != haltingState) {
      step();
    }
  }
  
} // end TM class