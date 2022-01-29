package SnakesAndLadders;

/**
 * Types of squares.
 * @author Sam Hirst
 * @version 1.0.0
 * @see Square
 * @since 1.0.0
 */
public enum SquareType {
    /** A normal square: if a player lands on an empty square, they remain on that square. */
    EMPTY,
    /** A ladder square: if a player lands on a ladder square, they climb the ladder to another square and make additional progress. */
    LADDER,
    /** A snake square: if a player lands on a snake square, they are chased to another square and lose progress. */
    SNAKE
}
