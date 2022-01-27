import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Player> players;
    private int currentPlayerIndex;
    private Dice dice;
    private ArrayList<GameListener> listeners;

    public Game() {
        this.board = new Board();
        this.players = new ArrayList<Player>();
        this.currentPlayerIndex = 0;
        this.dice = new Dice();
        this.listeners = new ArrayList<GameListener>();
    }

    public void addPlayer(String playerName) {
        Square startingSquare = this.board.getStartSquare();
        Player newPlayer = new Player(playerName, startingSquare);
        this.players.add(newPlayer);
    }

    public Player getCurrentPlayer() {
        return this.players.get(this.currentPlayerIndex);
    }

    public void takeTurn() {
        Player player = getCurrentPlayer();

        Square startSquare = player.getCurrentSquare();
        int startSquareIndex = this.board.getSquares().indexOf(startSquare);

        int diceRoll = this.dice.rollDice();
        GameTransmitter.transmitPlayerRollsDice(this.listeners, player, diceRoll);
        
        int endSquareIndex = startSquareIndex + diceRoll;

        if (!this.board.isIndexInBounds(endSquareIndex)) {
            GameTransmitter.transmitPlayerCannotProceed(this.listeners, player);
            return;
        }

        Square endSquare = this.board.getSquares().get(endSquareIndex);
        SquareType endSquareType = endSquare.getType();
        
        player.setCurrentSquare(endSquare);
        GameTransmitter.transmitPlayerLandsOnSquare(this.listeners, player, endSquare);

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

    private void nextPlayer() {
        GameTransmitter.transmitPlayerEndsTurn(this.listeners, this.getCurrentPlayer());

        this.currentPlayerIndex += 1;
        
        if (this.currentPlayerIndex > this.players.size() - 1) {
            this.currentPlayerIndex = 0;
        }

        GameTransmitter.transmitPlayerStartsTurn(this.listeners, this.getCurrentPlayer());
    }

    public void registerListener(GameListener newListener) {
        this.listeners.add(newListener);
    }
}