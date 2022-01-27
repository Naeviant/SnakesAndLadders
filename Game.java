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
        Square startingSquare = board.getStartSquare();
        Player newPlayer = new Player(playerName, startingSquare);
        players.add(newPlayer);
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }
    
    private void advancePlayer() {
        Player player = getCurrentPlayer();

        Square startSquare = player.getCurrentSquare();
        int startSquareIndex = board.getSquares().indexOf(startSquare);

        int diceRoll = dice.rollDice();
        
        int endSquareIndex = startSquareIndex + diceRoll;

        if (!board.isIndexInBounds(endSquareIndex)) {
            return;
        }
        Square endSquare = board.getSquares().get(endSquareIndex);
        SquareType endSquareType = endSquare.getType();

        player.setCurrentSquare(endSquare);

        if (endSquareType != SquareType.EMPTY) {
            int playerToIndex = endSquare.getTakesPlayerTo() - 1;
            Square playerToSquare = board.getSquares().get(playerToIndex);

            player.setCurrentSquare(playerToSquare);
        }
    }

    public void nextPlayer() {
        currentPlayerIndex += 1;
        
        if (currentPlayerIndex > players.size() - 1) {
            currentPlayerIndex = 0;
        }
    }
}