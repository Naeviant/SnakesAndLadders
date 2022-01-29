package SnakesAndLadders;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
    private Player player;
    
    private static final String PLAYER_NAME = "Player 1";
    private static final Square START_SQUARE = new Square(0, 0);

    @Before
    public void setUp() {
        player = new Player(PLAYER_NAME, START_SQUARE);
    }

    @Test
    public void testGettingPlayerName() {
        assertTrue(player.getName().equals(PLAYER_NAME));
    }

    @Test
    public void testRenamingPlayer() {
        player.setName("Player 2");
        assertTrue(this.player.getName().equals("Player 2"));
    }

    @Test
    public void testGettingPlayerPosition() {
        assertTrue(player.getCurrentSquare().equals(START_SQUARE));
    }

    @Test
    public void testMovingPlayer() {
        Square nextSquare = new Square(0, 0);
        player.setCurrentSquare(nextSquare);
        assertTrue(player.getCurrentSquare().equals(nextSquare));
    }
}
