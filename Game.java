import java.util.ArrayList;

public class Game {
    private static Board board;
    private static ArrayList<Player> players;
    private static Dice dice;

    private static void initialiseBoard() {
        board = new Board();
    }

    private static void initialisePlayers() {
        players = new ArrayList<Player>();
        
        Square startingSquare = board.getStartSquare();

        Player p1 = new Player("Player 1", startingSquare);
        Player p2 = new Player("Player 2", startingSquare);

        players.add(p1);
        players.add(p2);
    }  

    private static void initialiseDice() {
        dice = new Dice();
    }

    private static void advancePlayer(Player player) {
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

    public static void main(String[] args) {
        initialiseBoard();
        initialisePlayers();
        initialiseDice();
    }
}