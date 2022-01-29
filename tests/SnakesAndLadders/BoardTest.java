package SnakesAndLadders;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
    private Board board;
    
    @Before
    public void setUp() {
        board = new Board();
    }
    
    @Test
    public void testCorrectNumberOfSquares() {
        assertTrue(board.getSquares().size() == 100);
    }

    @Test
    public void testFirstSquareIsSquare1() {
        assertTrue(board.getStartSquare().getSquareNumber() == 1);
    }

    @Test
    public void testLastSquareIsSquare100() {
        assertTrue(board.getLastSquare().getSquareNumber() == 100);
    }

    @Test
    public void testBoundsCheckerWhenFirstValid() {
        assertTrue(board.isIndexInBounds(1));
    }

    @Test
    public void testBoundsCheckerWhenLastValid() {
        assertTrue(board.isIndexInBounds(100));
    }

    @Test
    public void testBoundsCheckerWhenTooLow() {
        assertFalse(board.isIndexInBounds(0));
    }

    @Test
    public void testBoundsCheckerWhenTooHigh() {
        assertFalse(board.isIndexInBounds(101));
    }

    @Test
    public void testSquareTypes() {
        int[] ladderSquares = {4, 12, 14, 22, 41, 54};
        int[] snakeSquares = {37, 47, 75, 94, 96};

        for (Square square : board.getSquares()) {
            if (Arrays.stream(ladderSquares).anyMatch(x -> { return x == square.getSquareNumber(); })) {
                assertTrue(square.getType() == SquareType.LADDER);
            } else if (Arrays.stream(snakeSquares).anyMatch(x -> { return x == square.getSquareNumber(); })) {
                assertTrue(square.getType() == SquareType.SNAKE);
            } else {
                assertTrue(square.getType() == SquareType.EMPTY);
            }
        }
    }
}
