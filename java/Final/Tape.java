import java.util.*;

public class Tape {
  
  private Cell head;
  private int N;
  
  public Tape() {
    this.head = new Cell();
    this.head.setContent('*');
    this.head.setNext(null);
    this.head.setPrev(null);
    this.head.setIndex(0);
    N++;
  }
  
  public Tape(String seed) {
    char[] cTape = seed.toCharArray();
    this.head = new Cell('*',null,null,0);
    for(int i=0; i<cTape.length; i++) {
      add(cTape[i]);
    }
    add('*');
    rewindHead();
  }
  
  public Cell getCurrentCell() {
    return head;
  }
  
  public void moveLeft() {
    if ( head.hasPrev() ) {
      head = head.getPrev();
    }
  }
  
  public void moveRight() {
    if( head.hasNext() ) {
      head = head.getNext();
    }
  }
  
  public int getSize() {
    return N;
  }
  
  public void add(char c) {
    int originalIndex = head.getIndex();
    forwardHead();
    
    int index = head.getIndex() + 1;
    Cell next = new Cell(c, null, head, index);
    head.setNext(next);
    
    rewindHead(originalIndex);
  }
  
  public void rewindHead() {
    while(head.hasPrev()) {
      moveLeft();
    }
  }
  
  public void rewindHead(int index) {
    while(head.hasPrev() && head.getIndex() > index) {
      moveLeft();
    }
  }
  
  public void forwardHead() {
    while(head.hasNext()) {
      moveRight();
    }
  }
      
  
  public void getTapeContents() {
    int originalIndex = head.getIndex();
    rewindHead();
    if (originalIndex == head.getIndex()) { System.out.print(" >"); }
    System.out.print(head);
    if (originalIndex == head.getIndex()) { System.out.print("< "); }
    while(head.hasNext()) {
      moveRight();
      if (originalIndex == head.getIndex()) { System.out.print(" >"); }
      System.out.print(head);
      if (originalIndex == head.getIndex()) { System.out.print("< "); }
    }
    System.out.print("\n");
    rewindHead(originalIndex);
  } 
  
  
} // end Tape class