package SnakesAndLadders;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DiceTest {
    private Dice dice;

    @Test
    public void testDice() {
        this.dice = new Dice();

        for (int i = 0; i < 1000; i++) {
            int diceResult = dice.rollDice();
            assertTrue(diceResult >= 1 && diceResult <= 6);
        }
    }    
}
