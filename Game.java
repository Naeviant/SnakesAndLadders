import java.util.ArrayList;

public class Game {
    private static Board board;
    private static ArrayList<Player> players;

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

    public static void main(String[] args) {
        initialiseBoard();
        initialisePlayers();

        System.out.println(board.getSquares());
        System.out.println(players);
    }
}