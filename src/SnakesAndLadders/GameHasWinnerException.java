package SnakesAndLadders;

/**
 * Thrown when a player attempts to take a turn after the game already has been won.
 * @author Sam Hirst
 * @version 1.1.0
 * @see Exception
 * @since 1.0.0
 */
public class GameHasWinnerException extends Exception {
    /**
     * Throw a new GameHasWinnerException.
     * @since 1.0.0
     */
    public GameHasWinnerException() {
        super("You cannot take your turn after the game has been won.");
    }
}
