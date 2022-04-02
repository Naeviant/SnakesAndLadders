package SnakesAndLadders;

/**
 * Defines the methods which a class must implement to use the SnakesAndLadders package.
 * @author Sam Hirst
 * @version 1.1.0
 * @since 1.0.0
 */
public interface GameListener {
    /**
     * Called whenever a player starts their turn.
     * @param player the player whose turn has started
     * @see Player
     */
    void onPlayerStartsTurn(Player player);

    /**
     * Called whenever a player rolls the dice.
     * @param player the player who rolled the dice
     * @param rollResult the result of the dice roll
     * @see Player
     */
    void onPlayerRollsDice(Player player, int rollResult);

    /**
     * Called whenever a player lands on a square.
     * @param player the player who has moved to a new square
     * @param squareLandedOn the square which the player has landed on
     * @see Player
     * @see Square
     */
    void onPlayerLandsOnSquare(Player player, Square squareLandedOn);

    /**
     * Called whenever a player climbs a ladder to a new square.
     * @param player the player who has moved to a new square
     * @param squareClimbedTo the square which the player has moved to
     * @see Player
     * @see Square
     */
    void onPlayerClimbsLadder(Player player, Square squareClimbedTo);

    /**
     * Called whenever a player is chased by a snake to a new square.
     * @param player the player who has moved to a new square
     * @param squareChasedTo the square which the player has moved to
     * @see Player
     * @see Square
     */
    void onPlayerChasedBySnake(Player player, Square squareChasedTo);

    /**
     * Called whenever a player has a dice roll which would take them off the end of the board.
     * The player is not moved in this case.
     * @param player the player who was unable to move
     * @see Player
     */
    void onPlayerCannotProceed(Player player);

    /**
     * Called whenever a player ends their turn.
     * @param player the player whose turn has ended
     * @see Player
     */
    void onPlayerEndsTurn(Player player);

    /**
     * Called whenever a player reaches the final square and wins.
     * @param player the player who has won
     * @see Player
     */
    void onPlayerWins(Player player);
}
