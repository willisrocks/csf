public class Transition {
  public char currentState, currentVal, newState, newVal, dir;
  
  public Transition (String cs, String cv, String ns, String nv, String d) {
    this.currentState = cs.charAt(0);
    this.currentVal   = cv.charAt(0);
    this.newState     = ns.charAt(0);
    this.newVal       = nv.charAt(0);
    this.dir          = d.charAt(0);
  }
  
  public Transition () {
//    this.currentState = "";
//    this.currentVal   = "";
//    this.newState     = "";
//    this.newVal       = "";
//    this.dir          = "";
  }
  
  public Transition (char cs, char cv, char ns, char nv, char d) {
    this.currentState = cs;
    this.currentVal   = cv;
    this.newState     = ns;
    this.newVal       = nv;
    this.dir          = d;
  }
  
  public char getCurrentState() {
    return currentState;
  }
  
  public char getCurrentVal() {
    return currentVal;
  }
  
  public char getNewState() {
    return newState;
  }
  
  public char getNewVal() {
    return newVal;
  }
  
  public char getDir() {
    return dir;
  }
  
  public String toString() {
    return "{Current State: " + currentState + ", Current Value: " + currentVal +
           ", New State: " + newState + ", New Value: " + newVal +
           ", Direction: " + dir + "}";
  }
    
} // end Transition class