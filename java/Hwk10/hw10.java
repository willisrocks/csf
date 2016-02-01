// Hangman
public class hw10 {
  
  // main method
  public static void main(String [] args) {
    mainMenu();
  }

  // main menu loop
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
  } // end main()
  
  // main game loop
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

} // end hw10 class