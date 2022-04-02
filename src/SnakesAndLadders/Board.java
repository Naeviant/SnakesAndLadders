package SnakesAndLadders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents the board that the game is played on.
 * @author Sam Hirst
 * @version 1.1.0
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
     * A map of squares where players are moved to when they land on a square (implements snakes and ladders)
     * @see java.util.Map
     * @since 1.1.0
     */
    private Map<Integer, Integer> movePlayerTo;

    /**
     * Generate a new board.
     * @see #generateSquares()
     * @see java.util.Map
     * @param movePlayerTo a map of squares where players are moved to when they land on a square (implements snakes and ladders)
     * @since 1.1.0
     */
    protected Board(Map<Integer, Integer> movePlayerTo) {
        if (movePlayerTo == null) {
            this.movePlayerTo = new HashMap<Integer, Integer>();
            this.movePlayerTo.put(4, 56);
            this.movePlayerTo.put(12, 50);
            this.movePlayerTo.put(14, 56);
            this.movePlayerTo.put(22, 58);
            this.movePlayerTo.put(37, 3);
            this.movePlayerTo.put(41, 79);
            this.movePlayerTo.put(47, 16);
            this.movePlayerTo.put(54, 88);
            this.movePlayerTo.put(75, 32);
            this.movePlayerTo.put(94, 71);
            this.movePlayerTo.put(96, 42);
        } else {
            this.movePlayerTo = movePlayerTo;
        }

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
     * Get a Square object which represents the square on the board where players win.
     * @return a Square object which represents the square on the board where players win
     * @see Square
     * @since 1.0.0
     */
    protected Square getLastSquare() {
        return this.getSquares().get(99);
    }

    /**
     * Check if a square number is within the bounds of the game board.
     * @param number the number of the square to check
     * @return true if the square is in bounds, false otherwise
     * @since 1.0.0
     */
    protected boolean isIndexInBounds(int number) {
        if (number > this.getSquares().size() || number < 1) {
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
        if (this.movePlayerTo.containsKey(number)) {
            return this.movePlayerTo.get(number);
        }

        return number;
    }
}
