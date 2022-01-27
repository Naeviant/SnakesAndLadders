import java.text.MessageFormat;

public class Square {
    private SquareType type;
    private int squareNumber;
    private int takesPlayerTo;
    
    public Square(int squareNumber, int takesPlayerTo) {
        this.setType(determineSquareType(squareNumber, takesPlayerTo));
        this.setSquareNumber(squareNumber);
        this.setTakesPlayerTo(takesPlayerTo);
    }

    public SquareType getType() {
        return this.type;
    }
    
    public void setType(SquareType type) {
        this.type = type;
    }
    
    public int getSquareNumber() {
        return this.squareNumber;
    }
    
    public void setSquareNumber(int squareNumber) {
        this.squareNumber = squareNumber;
    }
    
    public int getTakesPlayerTo() {
        return this.takesPlayerTo;
    }

    public void setTakesPlayerTo(int takesPlayerTo) {
        this.takesPlayerTo = takesPlayerTo;
    }

    private SquareType determineSquareType(int squareNumber, int takesPlayerTo) {
        if (squareNumber == takesPlayerTo) {
            return SquareType.EMPTY;
        }

        if (squareNumber < takesPlayerTo) {
            return SquareType.LADDER;
        }

        return SquareType.SNAKE;
    }

    public String toString() {
        return MessageFormat.format("Square {0} of type {1}", this.getSquareNumber(), this.getType());
    }
}
