// Hangman
// Elements:
// Main Menu with options to exit and start a new game

public class Hangman {

  public String[] dict = {"Chris", "Ross", "Simon"}; // dictionary of possible answers
  public String answer; // the right answer
  public String attempt; // keeps track of user's guesses
  
  // =========================================
  // Hangman()
  // Constructor class to create a new 
  // Hangman object
  // A new Hangman object can be created with
  // Hangman game = new Hangman()
  
  public Hangman() {
    this.answer = dict[myRand(0, dict.length - 1)];
    this.attempt = createAttempt(this.answer);
    
  } // end Hangman()
  
  // =========================================
  // createAttempt() takes the empty attempt
  // string, finds the length of the answer
  // string, and returns a new string masked
  // with '*' characters. createAttempt() is
  // only used in the Hangman constuctor
  
  private String createAttempt(String attempt) {
    int len = attempt.length();
    String a = "*";
    for (int i = 1; i < len; i++) {
      a += "*";
    }
    return a;
  } // end createAttempt()
  
  // =========================================
  // updateAttempt() takes a char 'c' and
  // unmasks the '*' characters in the 
  // attempt string where 'c' is located.
  // updateAttempt() is a public method
  
  public void updateAttempt(char c) {
    String s = this.attempt;
    char[] s_array = s.toCharArray();
    for (int i = 0; i < s_array.length; i++) {
      if (this.answer.charAt(i) == c) {
        s_array[i] = c;
      }
    }
    this.attempt = String.valueOf(s_array);
  } // end updateAttempt()
  
  // =========================================
  // guessCorrect takes a char 'c' and 
  // returns true if the answer contains 'c'
  // and false if not. This is a public method.
  
  public boolean guessCorrect(char c) {
    boolean result = false;
    
    if (this.answer.indexOf(c) > -1) {
      result = true;
    }
    
    return result;
  } // end guessCorrect()
  

  // =========================================
  // Helper Methods
  // =========================================
  
  // Creates a random number
  public static int myRand(int low, int high) {
    int rand=0;
    
    rand=((int)((Math.random()*(high-low+1))+low));
    
    return rand;
    
  } // end myRand()
  

} // end hw10 class
