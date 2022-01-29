package SnakesAndLadders;

public class Player {
    private String name;
    private Square currentSquare;

    protected Player(String name, Square currentSquare) {
        this.setName(name);
        this.setCurrentSquare(currentSquare);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Square getCurrentSquare() {
        return this.currentSquare;
    }

    protected void setCurrentSquare(Square currentSquare) {
        this.currentSquare = currentSquare;
    }

    public String toString() {
        return this.getName();
    }
}
