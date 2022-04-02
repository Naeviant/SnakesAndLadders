package SnakesAndLadders;

import java.util.ArrayList;

/**
 * Defines the methods which a class must implement to use the SnakesAndLadders package.
 * @author Sam Hirst
 * @version 1.1.0
 * @since 1.0.0
 */
public interface GameListener {
    /**
     * Called when players are rolling some dice to determine the order of play
     * @param numberOfDice the number of dice each player will roll
     */
    void onDecidingPlayerOrder(int rollResult);

    /**
     * Called when the order of play has been decided
     * @param playerOrder the list of players in the order that they will play
     * @see ArrayList
     * @see Player
     */
    void onDecidedPlayerOrder(ArrayList<Player> playerOrder);

    /**
     * Called whenever a player rolls the dice to determine the order of play
     * @param player the player who rolled the dice
     * @param rollResult the result of the dice roll
     * @see Player
     */
    void onPlayerInitialRoll(Player player, int rollResult);

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
     * Called whenever a player bounced back off the end of the board.
     * @param player the player who was bounced back
     * @see Player
     */
    void onPlayerBouncedBack(Player player);

    /**
     * Called whenever a player has a rolled a six and can roll again.
     * @param player the player who will roll again
     * @see Player
     */
    void onPlayerToRollAgain(Player player);

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
