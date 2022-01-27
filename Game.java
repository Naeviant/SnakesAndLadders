public class Game {
    private static Board board;

    public static void main(String[] args) {
        board = new Board();

        System.out.println(board.getSquares());
    }
}