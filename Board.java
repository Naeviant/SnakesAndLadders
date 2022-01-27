import java.util.ArrayList;

public class Board {
    private ArrayList<Square> squares;

    public Board() {
        this.generateSquares();
    }

    public ArrayList<Square> getSquares() {
        return this.squares;
    }

    public Square getStartSquare() {
        return this.getSquares().get(0);
    }

    private void generateSquares() {
        this.squares = new ArrayList<Square>();

        for (int squareNumber = 1; squareNumber <= 100; squareNumber++) {
            int movePlayerTo = getMovePlayerTo(squareNumber);
            Square squareToAdd = new Square(squareNumber, movePlayerTo);

            this.squares.add(squareToAdd);
        }
    }

    private int getMovePlayerTo(int index) {
        switch (index) {
            case 4:
                return 56;
            case 12:
                return 50;
            case 14:
                return 55;
            case 22:
                return 58;
            case 37:
                return 3;
            case 41:
                return 79;
            case 47:
                return 16;
            case 54:
                return 88;
            case 75:
                return 32;
            case 94:
                return 71;
            case 96:
                return 42;
            default:
                return index;
        }
    }
}
