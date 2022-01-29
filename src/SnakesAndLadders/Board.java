package SnakesAndLadders;

import java.util.ArrayList;

/**
 * Represents the board that the game is played on.
 * @author Sam Hirst
 * @version 1.0.0
 * @since 1.0.0
 * {@link java.util.ArrayList}.
 */
public class Board {
    /** 
     * An ArrayList of squares which make up the board.
     * @see java.util.ArrayList
     * @since 1.0.0
     */
    private ArrayList<Square> squares;

    /**
     * Generate a new board.
     * @see #generateSquares()
     * @since 1.0.0
     */
    protected Board() {
        this.generateSquares();
    }

    /**
     * Get an ArrayList of squares which make up the board.
     * @return an ArrayList of squares which make up the board
     * @see java.util.ArrayList
     * @since 1.0.0
     */
    protected ArrayList<Square> getSquares() {
        return this.squares;
    }

    /**
     * Get a Square object which represents the square on the board where players start.
     * @return a Square object which represents the square on the board where players start
     * @see Square
     * @since 1.0.0
     */
    protected Square getStartSquare() {
        return this.getSquares().get(0);
    }

    /**
     * Check if a square number is within the bounds of the game board.
     * @param number the number of the square to check
     * @return true if the square is in bounds, false otherwise
     * @since 1.0.0
     */
    protected boolean isIndexInBounds(int number) {
        if (number > this.getSquares().size() - 1) {
            return false;
        }
        return true;
    }

    /**
     * Generate the Squares which make up the game board.
     * @see #Board()
     * @since 1.0.0
     */
    private void generateSquares() {
        this.squares = new ArrayList<Square>();

        for (int squareNumber = 1; squareNumber <= 100; squareNumber++) {
            int movePlayerTo = getMovePlayerTo(squareNumber);
            Square squareToAdd = new Square(squareNumber, movePlayerTo);

            this.squares.add(squareToAdd);
        }
    }

    /**
     * Check where the player should be moved to if they land on a particular square.
     * If they've landed on a ladder, they will be moved to a square with a higher number.
     * If they've landed on a snake, they will be moved to a square with a lower number.
     * Otherwise, they'll remain on the square they landed on.
     * @param number the number of the square to check
     * @return The number of the square to which the player will move to if they land on the specified square.
     * @since 1.0.0
     */
    private int getMovePlayerTo(int number) {
        switch (number) {
            case 4:
                return 56;
            case 12:
                return 50;
            case 14:
                return 55;
            case 22:
                return 58;
            case 37:
                return 3;
            case 41:
                return 79;
            case 47:
                return 16;
            case 54:
                return 88;
            case 75:
                return 32;
            case 94:
                return 71;
            case 96:
                return 42;
            default:
                return number;
        }
    }
}
