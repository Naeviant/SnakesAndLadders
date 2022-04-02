package SnakesAndLadders;

/**
 * Thrown when a player attempts to take a turn after the game already has been won.
 * @author Sam Hirst
 * @version 1.1.0
 * @see Exception
 * @since 1.1.0
 */
public class InvalidSnakeOrLadderException extends Exception {
    /**
     * Throw a new InvalidSnakeOrLadderException.
     * @since 1.1.0
     */
    public InvalidSnakeOrLadderException(String message) {
        super(message);
    }
}
