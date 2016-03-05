public class Transition {
  private String currentState, currentVal, newState, newVal, dir;
  
  public Transition (String cs, String cv, String ns, String nv, String d) {
    this.currentState = cs;
    this.currentVal   = cv;
    this.newState     = ns;
    this.newVal       = nv;
    this.dir          = d;
  }
  
  public Transition () {
    this.currentState = "";
    this.currentVal   = "";
    this.newState     = "";
    this.newVal       = "";
    this.dir          = "";
  }
  
  public Transition (char cs, char cv, char ns, char nv, char d) {
    this.currentState = String.valueOf(cs);
    this.currentVal   = String.valueOf(cv);
    this.newState     = String.valueOf(ns);
    this.newVal       = String.valueOf(nv);
    this.dir          = String.valueOf(d);
  }
  
  public String getCurrentState () {
    return this.currentState;
  }
  
  public String getCurrentVal () {
    return this.currentVal;
  }
  
  public String toString() {
    return "{Current State: " + currentState + ", Current Value: " + currentVal +
           ", New State: " + newState + ", New Value: " + newVal +
           ", Direction: " + dir + "}";
  }
    
} // end Transition class