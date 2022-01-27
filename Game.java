import java.util.ArrayList;

public class Game {
    private static Board board;
    private static ArrayList<Player> players;
    private static int currentPlayerIndex;
    private static Dice dice;

    private static void advancePlayer() {
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

    public static void addPlayer(String playerName) {
        Square startingSquare = board.getStartSquare();
        Player newPlayer = new Player(playerName, startingSquare);
        players.add(newPlayer);
    }

    public static Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public static void nextPlayer() {
        currentPlayerIndex += 1;
        
        if (currentPlayerIndex > players.size() - 1) {
            currentPlayerIndex = 0;
        }
    }

    public static void main(String[] args) {
        board = new Board();
        players = new ArrayList<Player>();
        currentPlayerIndex = 0;
        dice = new Dice();
    }
}