package SnakesAndLadders;

/**
 * Represents a player in the game.
 * @author Sam Hirst
 * @version 1.1.0
 * @since 1.0.0
 */
public class Player {
    /**
     * The name of this player.
     * @since 1.0.0
     */
    private String name;
    /**
     * The square of the board which this player is currently on.
     * @see Square
     * @since 1.0.0
     */
    private Square currentSquare;

    /**
     * Generate a new player.
     * @param name the name of this player
     * @param currentSquare the square which the player should start on
     * @see Square
     * @since 1.0.0
     */
    protected Player(String name, Square currentSquare) {
        this.setName(name);
        this.setCurrentSquare(currentSquare);
    }

    /**
     * Get the name of this player.
     * @return the name of this player
     * @since 1.0.0
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set a new name for this player.
     * @param name the new name for this player
     * @since 1.0.0
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the square of the board which this player is currently on.
     * @return the square of the board which this player is currently on
     * @since 1.0.0
     */
    public Square getCurrentSquare() {
        return this.currentSquare;
    }

    /**
     * Sets the square of the board which this player is currently on.
     * @param currentSquare the square of the board which this player should now be on.
     * @since 1.0.0
     */
    protected void setCurrentSquare(Square currentSquare) {
        this.currentSquare = currentSquare;
    }

    /**
     * Gets a textual description of this square.
     * @return a textual description of this square
     * @since 1.0.0
     */
    public String toString() {
        return this.getName();
    }
}
