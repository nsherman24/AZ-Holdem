package view_controller; 
import model.Game;

/**
 * This plays a console game of Arizona Hold-Em, 
 * a reduced version of Texas Hold-Em
 * 
 * @author Rick Mercer and Noah Sherman
 */
public class Main {

  public static void main(String[] args) {
  // Commented out since you might a different name for Game in Iteration 2
    Game game = new Game();
    game.start();   
  }
}