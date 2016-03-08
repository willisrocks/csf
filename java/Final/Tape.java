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
  
  public void forwardHead(int index) {
    while(head.hasNext() && head.getIndex() > index) {
      moveRight();
    }
  }
  
  public void setCurrentCell(char c) {
    head.setContent(c);
  }
    
  private void addCellL() {
    int originalIndex = head.getIndex();
    
    rewindHead();
    Cell newCell = new Cell('*', head, null, head.getIndex()-1);
    head.setPrev(newCell);
    
    forwardHead(originalIndex);
  }
  
  public void addCellRight() {
    int originalIndex = head.getIndex();
    
    forwardHead();
    Cell newCell = new Cell('*', null, head, head.getIndex()+1);
    head.setNext(newCell);
    
    rewindHead(originalIndex);
  }
  
  public void reIndex() {
    int originalIndex = head.getIndex();
    
    int index = 0;
    int min = 0;
    rewindHead();
    
    while(head.hasNext()) {
      if(head.getIndex() < min) { min = head.getIndex(); }
      head.setIndex(index);
      index++;
      moveRight();
    }
    
    originalIndex += Math.abs(min);
    rewindHead(originalIndex);
  }
  
  public void addCellLeft() {
    addCellL();
    reIndex();
  }
    
  
  public void printIndexes() {
    int originalIndex = head.getIndex();
    rewindHead();
    while(head.hasNext()) {
      System.out.print(head.getIndex()+" ");
      moveRight();
    }
    System.out.print("\n");
    rewindHead(originalIndex);
  }
    
      
      
  
  public void getTapeContents() {
    int originalIndex = head.getIndex();
    rewindHead();
    if (originalIndex == head.getIndex()) { System.out.print(">"); }
    System.out.print(head);
    if (originalIndex == head.getIndex()) { System.out.print("<"); }
    while(head.hasNext()) {
      moveRight();
      if (originalIndex == head.getIndex()) { System.out.print(">"); }
      System.out.print(head);
      if (originalIndex == head.getIndex()) { System.out.print("<"); }
    }
    System.out.print("\n");
    rewindHead(originalIndex);
  } 
  
  
} // end Tape class