// Hangman
// Elements:
// Main Menu with options to exit and start a new game

public class Hangman {

  public String[] dict = {"chris", "ross", "simon", "chad", "mike", "naomi", 
                          "devlin", "eli", "thomas", "brianna", "christopher",
                          "badriya", "matthew", "zachary", "josh"}; // dictionary of possible answers
  public int max; // the max amount of tries
  public int lives; // the amount of remaining tries left
  public String answer; // the right answer
  public String attempt; // keeps track of user's guesses
  public int[][] lettersTried; // keeps track of when a user has guessed a letter
  public int currentGuess; // keeps track of the user's current guess
  
  // =========================================
  // Hangman()
  // Constructor class to create a new 
  // Hangman object
  // A new Hangman object can be created with
  // Hangman game = new Hangman()
  
  public Hangman() {
    this.max = 6;
    this.lives = this.max;
    this.answer = dict[myRand(0, dict.length - 1)];
    this.attempt = createAttempt(this.answer);
    this.lettersTried = buildLetters();
    this.currentGuess = -1;
    
  }
  
  // contructor with the optional number of max lives
  public Hangman(int m) {
    this.max = m;
    this.lives = this.max;
    this.answer = dict[myRand(0, dict.length - 1)];
    this.attempt = createAttempt(this.answer);
    this.lettersTried = buildLetters();
    this.currentGuess = -1;
    
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
  
  public void updateAttempt(int g) {
    char c = (char) g;
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
  // guessCorrect() takes a char 'c' and 
  // returns true if the answer contains 'c'
  // and false if not. This is a public method.
  
  public boolean guessCorrect(int g) {
    boolean result = false;
    char c = (char) g;
    
    if (this.answer.indexOf(c) > -1) {
      result = true;
    }
    
    return result;
  } // end guessCorrect()
  
  // =========================================
  // getGuess() takes a char 'c' and
  // and sets the current guess to 'c'.
  // If they've already guessed 'c', getGuess
  // rejects the guess
  
  public void getGuess() {
    System.out.print("Enter guess: ");
    int guess = (int) (Keyboard.readChar());
    if ( (guess < 97) || (guess > 122)) {
      System.out.println("Please enter a letter [a-z].");
      this.currentGuess = -1;
    }
    else if (lettersTried[guess-97][1] > 0) {
      System.out.println("You've already tried this letter, please try again.");
      this.currentGuess = -1;
    }
    else {
      this.currentGuess = guess;
      this.lettersTried[guess-97][1] += 1;
    }
  } // end getGuess()
  
  public void drawScreen() {
    System.out.println(this.attempt + " - lives left: " + this.lives);
    System.out.println("\n");
  }
  
  

  // =========================================
  // Helper Methods
  // =========================================
  
  // Creates a random number
  public static int myRand(int low, int high) {
    int rand=0;
    
    rand=((int)((Math.random()*(high-low+1))+low));
    
    return rand;
    
  } // end myRand()
  
  // create letter array
  public static int[][] buildLetters() {
    int[][] letters = new int[26][2];
    int asci = 97;
    for (int i=0; i < letters.length; i++) {
      letters[i][0] = asci;
      asci++;
    }
    return letters;
  }
  
  

} // end hw10 class
