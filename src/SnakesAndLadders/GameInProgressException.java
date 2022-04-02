package SnakesAndLadders;

/**
 * Thrown when a player is added while the game is in progress. Also thrown if the game is started twice.
 * @author Sam Hirst
 * @version 1.1.0
 * @see Exception
 * @since 1.0.0
 */
public class GameInProgressException extends Exception {
    /**
     * Throw a new GameNotStartedException.
     * @param message the message to display with the exception
     * @since 1.0.0
     */
    public GameInProgressException(String message) {
        super(message);
    }
}
