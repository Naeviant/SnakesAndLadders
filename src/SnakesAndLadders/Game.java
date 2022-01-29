package SnakesAndLadders;

import java.util.ArrayList;

/**
 * Represents the game of Snakes and Ladders.
 * @author Sam Hirst
 * @version 1.0.0
 * @since 1.0.0
 */
public class Game {
    /**
     * The board which the game is played on.
     * @see Board
     * @since 1.0.0
     */
    private Board board;

    /**
     * The players which are participating in the game.
     * @see ArrayList
     * @see Player
     * @since 1.0.0
     */
    private ArrayList<Player> players;

    /**
     * The index in the list of players which holds the player whose turn it currently is.
     * @see #players
     * @since 1.0.0
     */
    private int currentPlayerIndex;
    
    /**
     * The dice which players use in the game.
     * @see Dice
     * @since 1.0.0
     */
    private Dice dice;

    /**
     * If the game is in progress.
     * @since 1.0.0
     */
    private boolean inProgress;

    /**
     * If the game has been won.
     * @since 1.0.0
     */
    private boolean beenWon;

    /**
     * The registered listeners for the game.
     * @see ArrayList
     * @see GameListener
     * @see #registerListener(GameListener)
     * @since 1.0.0
     */
    private ArrayList<GameListener> listeners;

    /**
     * Create a new game of Snakes and Ladders.
     * @since 1.0.0
     */
    public Game() {
        this.board = new Board();
        this.players = new ArrayList<Player>();
        this.currentPlayerIndex = 0;
        this.dice = new Dice();
        this.inProgress = false;
        this.listeners = new ArrayList<GameListener>();
    }

    /**
     * Add a new player to the game.
     * @param playerName the name of the new player
     * @throws GameInProgressException if the game has already started
     * @since 1.0.0
     */
    public void addPlayer(String playerName) throws GameInProgressException {
        if (this.isInProgress()) {
            throw new GameInProgressException("Players can only be added before the game starts.");
        }

        Square startingSquare = this.board.getStartSquare();
        Player newPlayer = new Player(playerName, startingSquare);
        this.players.add(newPlayer);
    }

    /**
     * Get the player whose turn it currently is.
     * @return the player whose turn it currently is
     * @since 1.0.0
     */
    public Player getCurrentPlayer() {
        return this.players.get(this.currentPlayerIndex);
    }

    /**
     * Get all players who are involved in this game.
     * @return all players who are involved in this game
     * @see ArrayList
     * @see Player
     * @since 1.0.0
     */
    public ArrayList<Player> getAllPlayers() {
        return this.players;
    }

    /**
     * Get whether or not the game is in progress.
     * @return true if the game is in progress, false otherwise
     */
    public boolean isInProgress() {
        return this.inProgress;
    }

    /**
     * Get whether or not the game has been won.
     * @return true if the game has been won, false otherwise
     */
    public boolean hasBeenWon() {
        return this.beenWon;
    }

    /**
     * Begin the game.
     * @throws NotEnoughPlayersException if there are less than two players in the game
     * @throws GameInProgressException if the game has already started
     * @since 1.0.0
     */
    public void start() throws NotEnoughPlayersException, GameInProgressException {
        if (this.getAllPlayers().size() < 2) {
            throw new NotEnoughPlayersException();
        }
        if (this.isInProgress()) {
            throw new GameInProgressException("The game has already started.");
        }
        this.inProgress = true;
    }

    /**
     * Make the current player take their turn. This will roll the dice and move the player.
     * @throws GameNotStartedException if the game has not started yet
     * @throws GameHasWinnerException if the game already has a winner
     * @since 1.0.0
     */
    public void takeTurn() throws GameNotStartedException, GameHasWinnerException {
        if (!this.isInProgress()) {
            throw new GameNotStartedException();
        }
        if (this.hasBeenWon()) {
            throw new GameHasWinnerException();
        }

        Player player = this.getCurrentPlayer();

        GameTransmitter.transmitPlayerStartsTurn(this.listeners, player);

        Square startSquare = player.getCurrentSquare();
        int startSquareIndex = this.board.getSquares().indexOf(startSquare);

        int diceRoll = this.dice.rollDice();
        GameTransmitter.transmitPlayerRollsDice(this.listeners, player, diceRoll);
        
        int endSquareIndex = startSquareIndex + diceRoll;

        if (!this.board.isIndexInBounds(endSquareIndex + 1)) {
            GameTransmitter.transmitPlayerCannotProceed(this.listeners, player);
            this.nextPlayer();
            return;
        }

        Square endSquare = this.board.getSquares().get(endSquareIndex);
        SquareType endSquareType = endSquare.getType();
        
        player.setCurrentSquare(endSquare);
        GameTransmitter.transmitPlayerLandsOnSquare(this.listeners, player, endSquare);

        if (this.board.getLastSquare().equals(endSquare)) {
            this.beenWon = true;
            GameTransmitter.transmitPlayerWins(this.listeners, player);
        }

        if (endSquareType != SquareType.EMPTY) {
            int playerToIndex = endSquare.getTakesPlayerTo() - 1;
            Square playerToSquare = this.board.getSquares().get(playerToIndex);

            player.setCurrentSquare(playerToSquare);

            if (endSquareType == SquareType.LADDER) {
                GameTransmitter.transmitPlayerClimbsLadder(this.listeners, player, playerToSquare);
            }
            if (endSquareType == SquareType.SNAKE) {
                GameTransmitter.transmitPlayerChasedBySnake(this.listeners, player, playerToSquare);
            }
        }

        this.nextPlayer();
    }

    /**
     * Move on to the next player.
     * @since 1.0.0
     */
    private void nextPlayer() {
        GameTransmitter.transmitPlayerEndsTurn(this.listeners, this.getCurrentPlayer());

        this.currentPlayerIndex += 1;
        
        if (this.currentPlayerIndex > this.players.size() - 1) {
            this.currentPlayerIndex = 0;
        }
    }

    /**
     * Register a new listener.
     * @param newListener the new listener.
     * @see GameListener
     * @since 1.0.0
     */
    public void registerListener(GameListener newListener) {
        this.listeners.add(newListener);
    }
}