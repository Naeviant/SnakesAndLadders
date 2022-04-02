package SnakesAndLadders;

import java.text.MessageFormat;

/**
 * Represents a square which makes up part of the board that the game is played on.
 * @author Sam Hirst
 * @version 1.1.0
 * @see Board
 * @since 1.0.0
 */
public class Square {
    /** 
     * The type of this square.
     * @see SquareType
     * @since 1.0.0
     */
    private SquareType type;

    /** 
     * The number of this square.
     * @since 1.0.0
     */
    private int squareNumber;
    
    /** 
     * The number of the square where the player goes to if they land on this square.
     * @since 1.0.0
     */
    private int takesPlayerTo;
    
    /**
     * Generate a new square.
     * @param squareNumber the number of this square
     * @param takesPlayerTo the number of the square where the player goes to if they land on this square
     * @since 1.0.0
     */
    protected Square(int squareNumber, int takesPlayerTo) {
        this.setSquareNumber(squareNumber);
        this.setTakesPlayerTo(takesPlayerTo);
        this.setType(determineSquareType());
    }

    /**
     * Get the type of this square.
     * @return The type of this square
     * @see SquareType
     * @since 1.0.0
     */
    public SquareType getType() {
        return this.type;
    }
    
    /**
     * Sets the type of this square.
     * @param type the new type of this square
     * @see SquareType
     * @since 1.0.0
     */
    private void setType(SquareType type) {
        this.type = type;
    }
    
    /**
     * Get the number of this square.
     * @return the number of this square
     * @since 1.0.0
     */
    public int getSquareNumber() {
        return this.squareNumber;
    }
    
    /**
     * Sets the number of this square.
     * @param squareNumber the new number of this square
     * @since 1.0.0
     */
    private void setSquareNumber(int squareNumber) {
        this.squareNumber = squareNumber;
    }
    
    /**
     * Get the number of the square where the player goes to if they land on this square
     * @return the number of the square where the player goes to if they land on this square
     * @since 1.0.0
     */
    public int getTakesPlayerTo() {
        return this.takesPlayerTo;
    }

    /**
     * Sets the number of the square where the player goes to if they land on this square
     * @param takesPlayerTo the new number of the square where the player goes to if they land on this square
     * @since 1.0.0
     */
    private void setTakesPlayerTo(int takesPlayerTo) {
        this.takesPlayerTo = takesPlayerTo;
    }

    /**
     * Determines what type of square this is, given its number and the number of the square where the player goes to if they land on this square
     * @return the type of this square.
     * @see SquareType
     * @since 1.0.0
     */
    private SquareType determineSquareType() {
        int squareNumber = this.getSquareNumber();
        int takesPlayerTo = this.getTakesPlayerTo();

        if (squareNumber == takesPlayerTo) {
            return SquareType.EMPTY;
        }

        if (squareNumber < takesPlayerTo) {
            return SquareType.LADDER;
        }

        return SquareType.SNAKE;
    }

    /**
     * Gets a textual description of this square.
     * @return a textual description of this square
     * @since 1.0.0
     */
    public String toString() {
        return MessageFormat.format("Square {0} of type {1}", this.getSquareNumber(), this.getType());
    }
}
