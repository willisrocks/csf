import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class h9t extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testGoodMagicSquare() {
    int[][] magic_square = {{8,1,6},{3,5,7},{4,9,2}};
    boolean actual = h9.detectMagic(magic_square);
    
    assertTrue("{{8,1,6},{3,5,7},{4,9,2}} should be true", actual);   
  }
  
  public void testRectangle() {
    int[][] rectangle = {{1,2},{2}};
    boolean actual = h9.detectMagic(rectangle);
    
    assertFalse("Magic Square must be a rectangle", actual);
  }
  
  public void testRange() {
    int[][] grid = h9.make(3, 3, 1, 1);
    boolean actual = h9.detectMagic(grid);
    
    assertFalse("The array must only contain values 1 : n^2", actual);
  }
  
  public void testSums() {
    int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
    boolean actual = h9.detectMagic(grid);
    
    assertFalse("The sums of the rows, cols, and diags must equal the magic number", actual);
  }
  
  public void testMakeMagic() {
    int[][] x = h9.makeMagic(3);
    boolean actual = h9.detectMagic(x);
    
    assertTrue("MakeMagic() should create a magic square", actual);
  }
}
