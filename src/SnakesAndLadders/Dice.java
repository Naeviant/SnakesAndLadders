package SnakesAndLadders;

import java.util.Random;

/**
 * Represents the dice that a player rolls.
 * @author Sam Hirst
 * @version 1.0.0
 * @since 1.0.0
 */
public class Dice {
    /**
     * A random object used to generate the dice result.
     * @see java.util.Random
     * @since 1.0.0
     */
    private Random r;

    /**
     * Generate a new dice.
     * @since 1.0.0
     */
    protected Dice() {
        r = new Random();
    }

    /**
     * Roll the dice.
     * @return The result of the dice roll: a number between 1 and 6 (inclusive).
     * @since 1.0.0
     */
    protected int rollDice() {
        return r.nextInt(6) + 1;
    }
}
