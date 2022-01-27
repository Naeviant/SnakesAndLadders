import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Player> players;
    private int currentPlayerIndex;
    private Dice dice;

    public Game() {
        this.board = new Board();
        this.players = new ArrayList<Player>();
        this.currentPlayerIndex = 0;
        this.dice = new Dice();
    }

    public void addPlayer(String playerName) {
        Square startingSquare = this.board.getStartSquare();
        Player newPlayer = new Player(playerName, startingSquare);
        this.players.add(newPlayer);
    }

    public Player getCurrentPlayer() {
        return this.players.get(this.currentPlayerIndex);
    }

    private void advancePlayer() {
        Player player = getCurrentPlayer();

        Square startSquare = player.getCurrentSquare();
        int startSquareIndex = this.board.getSquares().indexOf(startSquare);

        int diceRoll = this.dice.rollDice();
        
        int endSquareIndex = startSquareIndex + diceRoll;

        if (!this.board.isIndexInBounds(endSquareIndex)) {
            return;
        }
        Square endSquare = this.board.getSquares().get(endSquareIndex);
        SquareType endSquareType = endSquare.getType();

        player.setCurrentSquare(endSquare);

        if (endSquareType != SquareType.EMPTY) {
            int playerToIndex = endSquare.getTakesPlayerTo() - 1;
            Square playerToSquare = this.board.getSquares().get(playerToIndex);

            player.setCurrentSquare(playerToSquare);
        }
    }

    public void nextPlayer() {
        this.currentPlayerIndex += 1;
        
        if (this.currentPlayerIndex > this.players.size() - 1) {
            this.currentPlayerIndex = 0;
        }
    }
}