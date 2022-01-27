import java.util.ArrayList;

public class Board {
    private ArrayList<Square> squares;

    public Board() {
        this.generateSquares();
    }

    public ArrayList<Square> getSquares() {
        return squares;
    }

    private void generateSquares() {
        this.squares = new ArrayList<Square>();

        for (int squareNumber = 0; squareNumber < 100; squareNumber++) {
            int movePlayerTo = getMovePlayerTo(squareNumber);
            Square squareToAdd = new Square(squareNumber, movePlayerTo);

            this.squares.add(squareToAdd);
        }
    }

    private int getMovePlayerTo(int index) {
        return index;
    }
}
