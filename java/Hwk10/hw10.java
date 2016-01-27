// Hangman
// Elements:
// Main Menu with options to exit and start a new game

public class hw10 {

  // main loop, provides the main menu
  // with an exit and start new game
  // options
  public static void main() {
    
  } // end main()
  
  // startGame() takes a boolean difficulty and
  // starts the main hangman loop
  public static void startGame(boolean hard) {
    int num_total = 0; // number of guesses so far
    int num_bad = 0; // number of wrong guesses
    int num_allowed = 0; // number total guesses allowed
    String answer = "word";
    //String p_word = new String(answer.length());
    
    // draw the gallow on hard mode
    if (hard) {
      num_bad = 5;
    } 
    
    // draw the screen
    drawScreen(num_bad);
    
    // main hangman loop
    while (num_bad < num_allowed) {
      // draw screen
      // guess
      // update screen
      guess('c', answer);
      drawScreen(num_bad);
    }
    

  } // end startGame()
  
  public static boolean guess(char c, String a) {
    boolean guess = false;
    
    // search word
    
    return guess;
  }
  
  public static void drawScreen(int bad) {
    
  }

} // end hw10 class