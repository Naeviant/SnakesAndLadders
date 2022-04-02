package SnakesAndLadders;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
    private Game game;
    
    @Before
    public void setUp() {
        try {
            game = new Game();
        } catch (InvalidSnakeOrLadderException e) {}
    }

    @Test
    public void testGameNotInProgressAtStart() {
        assertFalse(game.isInProgress());
    }

    @Test
    public void testGameNotWonAtStart() {
        assertFalse(game.hasBeenWon());
    }

    @Test
    public void testGameHasNoPlayersAtStart() {
        assertTrue(game.getAllPlayers().size() == 0);
    }

    @Test
    public void testAddingPlayer() {
        try {
            game.addPlayer("Player 1");
            assertTrue(game.getAllPlayers().size() == 1);
            assertTrue(game.getAllPlayers().get(0).getName().equals("Player 1"));
        } catch (GameInProgressException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testAddingPlayerAfterGameStartThrowsException() {
        try {
            game.addPlayer("Player 1");
            game.addPlayer("Player 2");
            game.start();
        } catch (GameInProgressException e) {
            fail(e.getMessage());
        } catch (NotEnoughPlayersException e) {
            fail(e.getMessage());
        }

        assertThrows(GameInProgressException.class, () -> game.addPlayer("Player 3"));
    }

    @Test
    public void testStartingGameWithoutPlayersThrowsException() {
        assertThrows(NotEnoughPlayersException.class, () -> game.start());
    }

    @Test
    public void testTakingTurn() {
        try {
            game.addPlayer("Player 1");
            game.addPlayer("Player 2");
            game.start();

            assertTrue(game.getCurrentPlayer().getName().equals("Player 1"));
            game.takeTurn();
            assertTrue(game.getCurrentPlayer().getName().equals("Player 2"));
            game.takeTurn();
            assertTrue(game.getCurrentPlayer().getName().equals("Player 1"));
        } catch (GameInProgressException e) {
            fail(e.getMessage());
        } catch (NotEnoughPlayersException e) {
            fail(e.getMessage());
        } catch (GameNotStartedException e) {
            fail(e.getMessage());
        } catch (GameHasWinnerException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testTakingTurnWithoutStartingGame() {
        assertThrows(GameNotStartedException.class, () -> game.takeTurn());
    }

    @Test
    public void testPlayerMovement() {
        try {
            game.addPlayer("Player 1");
            game.addPlayer("Player 2");
            game.start();

            assertTrue(game.getCurrentPlayer().getName().equals("Player 1"));
            game.takeTurn();
        } catch (GameInProgressException e) {
            fail(e.getMessage());
        } catch (NotEnoughPlayersException e) {
            fail(e.getMessage());
        } catch (GameNotStartedException e) {
            fail(e.getMessage());
        } catch (GameHasWinnerException e) {
            fail(e.getMessage());
        }

        int currentSquareNumber = game.getAllPlayers().get(0).getCurrentSquare().getSquareNumber();
        assertTrue(currentSquareNumber > 1);
    }

    @Test
    public void testWinDetection() {
        try {
            game.addPlayer("Player 1");
            game.addPlayer("Player 2");
            game.start();

            while (!game.hasBeenWon()) {
                game.takeTurn();
            }

            int currentPlayerIndex = game.getAllPlayers().indexOf(game.getCurrentPlayer());
            if (currentPlayerIndex == 0) {
                assertTrue(game.getAllPlayers().get(1).getCurrentSquare().getSquareNumber() == 100);
            } else if (currentPlayerIndex == 1) {
                assertTrue(game.getAllPlayers().get(0).getCurrentSquare().getSquareNumber() == 100);
            }
        } catch (GameInProgressException e) {
            fail(e.getMessage());
        } catch (NotEnoughPlayersException e) {
            fail(e.getMessage());
        } catch (GameNotStartedException e) {
            fail(e.getMessage());
        } catch (GameHasWinnerException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testTakingTurnAfterWinThrowsException() {
        try {
            game.addPlayer("Player 1");
            game.addPlayer("Player 2");
            game.start();

            while (!game.hasBeenWon()) {
                game.takeTurn();
            }
        } catch (GameInProgressException e) {
            fail(e.getMessage());
        } catch (NotEnoughPlayersException e) {
            fail(e.getMessage());
        } catch (GameNotStartedException e) {
            fail(e.getMessage());
        } catch (GameHasWinnerException e) {
            fail(e.getMessage());
        }

        assertThrows(GameHasWinnerException.class, () -> game.takeTurn());
    }
}
