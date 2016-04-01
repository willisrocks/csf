import java.util.*;

public class Cell {
  
  private char content;
  private Cell next;
  private Cell prev;
  private int index;
  
  public Cell(char content, Cell next, Cell prev, int index) {
    this.content = content;
    this.next = next;
    this.prev = prev;
    this.index = index;
  }
  
  public Cell() { }
  
  public Cell(char content) {
    this.content = content;
  }
  
  public char getContent() {
    return content;
  }
  
  public void setContent(char content) {
    this.content = content;
  }
  
  public Cell getNext() {
    return next;
  }
  
  public void setNext(Cell next) {
    this.next = next;
  }
  
  public Cell getPrev() {
    return prev;
  }
  
  public void setPrev(Cell prev) {
    this.prev = prev;
  }
  
  public int getIndex() {
    return index;
  }
  
  public void setIndex(int index) {
    this.index = index;
  }
  
  public boolean hasPrev() {
    return prev != null;
  }
  
  public boolean hasNext() {
    return next != null;
  }  
  
  public String toString() {
    return "" + content;
  }
  
  protected Cell clone() {
    Cell clone = new Cell();
    clone.content = this.content;
    clone.prev = this.prev;
    clone.next = this.next;
    clone.index = this.index;
 
    return clone;
  }
  
  
} // end Cell class