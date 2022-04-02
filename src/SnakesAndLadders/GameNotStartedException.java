package SnakesAndLadders;

/**
 * Thrown when a player attempts to take a turn before the game has started.
 * @author Sam Hirst
 * @version 1.1.0
 * @see Exception
 * @since 1.0.0
 */
public class GameNotStartedException extends Exception {
    /**
     * Throw a new GameNotStartedException.
     * @since 1.0.0
     */
    public GameNotStartedException() {
        super("You cannot take your turn until the game has started.");
    }
}
