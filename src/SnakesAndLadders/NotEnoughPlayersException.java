package SnakesAndLadders;

/**
 * Thrown when a game is started with less than two players.
 * @author Sam Hirst
 * @version 1.1.0
 * @see Exception
 * @since 1.0.0
 */
public class NotEnoughPlayersException extends Exception {
    /**
     * Throw a new NotEnoughPlayersException.
     * @since 1.0.0
     */
    public NotEnoughPlayersException() {
        super("You must have at least two players to start a game.");
    }
}
