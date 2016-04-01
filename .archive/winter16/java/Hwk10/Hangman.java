/* *****************************************

   Title: Hangman
   Author: Chris Fenton
   Last Modified: 2/2/2016
 
   Description: Short hangman game for CSF

***************************************** */

public class Hangman {

  // dictionary of possible answers
  public String[] dict = {"chris", "ross", "simon", "chad", "mike", "naomi", 
                          "devlin", "eli", "thomas", "brianna", "christopher",
                          "badriya", "matthew", "zachary", "josh"};
  public int max; // the max amount of tries
  public int lives; // the amount of remaining tries left
  public String answer; // the right answer
  public String attempt; // keeps track of user's guesses
  public int[][] lettersTried; // keeps track of when a user has guessed a letter
  public int currentGuess; // keeps track of the user's current guess
  
  // =========================================
  // main method(), used to invoke mainMenu()
  // when running the program on the command
  // line
  
  public static void main(String [] args) {
    mainMenu();
  } // end main()

  // =========================================
  // mainMenu(), the main menu loop
  // provides options to play the game
  // or exit
  
  public static void mainMenu() {
    int option = 0;
    
    while (option != 2) {
      System.out.println("Enter [1] to play hangperson or [2] to quit: ");
      option = Keyboard.readInt();
      if (option == 1) {
        gameLoop();
      }
    }
    
    System.out.println("Goodbye!");
  } // end mainMenu()
  
  // =========================================
  // gameLoop(), the main game loop
  // invokes the Hangman object and
  // provides the game logic
  
  public static void gameLoop() {
    // Create Hangman object
    Hangman game = new Hangman();
    
    System.out.println("The goal of the game is to "
                        + "guess the names of the people "
                        + "in our class.\n");
    
    while ( !(game.attempt.equals(game.answer)) ) {
      game.drawScreen();
      game.getGuess();
      if (game.guessCorrect(game.currentGuess)) {
        game.updateAttempt(game.currentGuess);
        game.currentGuess = -1;
      } else {
        game.lives -= 1;
      }
      
      if (game.lives == 0) break;
      
      //System.out.println(game.attempt + " - " + game.answer);
    }
    
    if (game.attempt.equals(game.answer)) {
      System.out.println("\nYou won!!!");
    } else {
      System.out.println("\nYou lost!!!");
    }
    
    System.out.println("The correct answer was " + game.answer + "\n");
  } // end gameLoop()
  
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
    int guess = (int) (Character.toLowerCase(Keyboard.readChar()));
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
  
  // =========================================
  // drawScreen() updates the input prompt
  // displaying the current attempt and
  // lives left
  
  public void drawScreen() {
    System.out.println(this.attempt + " - lives left: " + this.lives);
    System.out.println("\n");
  } // end drawScreen()
  

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
