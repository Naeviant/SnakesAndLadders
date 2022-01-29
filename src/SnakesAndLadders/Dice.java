package SnakesAndLadders;

import java.util.Random;

public class Dice {
    private Random r;

    protected Dice() {
        r = new Random();
    }

    protected int rollDice() {
        return r.nextInt(6) + 1;
    }
}
