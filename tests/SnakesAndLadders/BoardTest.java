package SnakesAndLadders;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
    private Board board;
    
    @Before
    public void setUp() {
        try {
            board = new Board(null);
        } catch (InvalidSnakeOrLadderException e) {
            fail();
        }
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

    @Test
    public void testValidCustomLadder() {
        Map<Integer, Integer> snakesAndLadders = new HashMap<Integer, Integer>();
        snakesAndLadders.put(25, 50);
        
        try {
            new Board(snakesAndLadders);
        } catch (InvalidSnakeOrLadderException e) {
            fail();
        }
    }

    @Test
    public void testValidCustomSnake() {
        Map<Integer, Integer> snakesAndLadders = new HashMap<Integer, Integer>();
        snakesAndLadders.put(75, 50);
        
        try {
            new Board(snakesAndLadders);
        } catch (InvalidSnakeOrLadderException e) {
            fail();
        }
    }

    @Test
    public void testCustomSnakeOrLadderWithSameStartAndEnd() {
        Map<Integer, Integer> snakesAndLadders = new HashMap<Integer, Integer>();
        snakesAndLadders.put(50, 50);

        assertThrows(InvalidSnakeOrLadderException.class, () -> { new Board(snakesAndLadders); });
    }

    @Test
    public void testCustomSnakeOrLadderWithStartBeforeSquare2() {
        Map<Integer, Integer> snakesAndLadders = new HashMap<Integer, Integer>();
        snakesAndLadders.put(1, 50);

        assertThrows(InvalidSnakeOrLadderException.class, () -> { new Board(snakesAndLadders); });
    }

    @Test
    public void testCustomSnakeOrLadderWithEndBeforeSquare2() {
        Map<Integer, Integer> snakesAndLadders = new HashMap<Integer, Integer>();
        snakesAndLadders.put(50, 1);

        assertThrows(InvalidSnakeOrLadderException.class, () -> { new Board(snakesAndLadders); });
    }

    @Test
    public void testCustomSnakeOrLadderWithStartAfterSquare98() {
        Map<Integer, Integer> snakesAndLadders = new HashMap<Integer, Integer>();
        snakesAndLadders.put(99, 50);

        assertThrows(InvalidSnakeOrLadderException.class, () -> { new Board(snakesAndLadders); });
    }

    @Test
    public void testCustomSnakeOrLadderWithEndAfterSquare98() {
        Map<Integer, Integer> snakesAndLadders = new HashMap<Integer, Integer>();
        snakesAndLadders.put(50, 99);

        assertThrows(InvalidSnakeOrLadderException.class, () -> { new Board(snakesAndLadders); });
    }
}
