package SnakesAndLadders;

import java.util.ArrayList;

public class GameTransmitter {
    protected GameTransmitter() {}

    protected static void transmitPlayerStartsTurn(ArrayList<GameListener> listeners, Player player) {
        for (GameListener listener : listeners) {
            listener.onPlayerStartsTurn(player);
        }
    }

    protected static void transmitPlayerRollsDice(ArrayList<GameListener> listeners, Player player, int rollResult) {
        for (GameListener listener : listeners) {
            listener.onPlayerRollsDice(player, rollResult);
        }
    }

    protected static void transmitPlayerLandsOnSquare(ArrayList<GameListener> listeners, Player player, Square squareLandedOn) {
        for (GameListener listener : listeners) {
            listener.onPlayerLandsOnSquare(player, squareLandedOn);
        }
    }

    protected static void transmitPlayerClimbsLadder(ArrayList<GameListener> listeners, Player player, Square squareClimbedTo) {
        for (GameListener listener : listeners) {
            listener.onPlayerClimbsLadder(player, squareClimbedTo);
        }
    }

    protected static void transmitPlayerChasedBySnake(ArrayList<GameListener> listeners, Player player, Square squareChasedTo) {
        for (GameListener listener : listeners) {
            listener.onPlayerChasedBySnake(player, squareChasedTo);
        }
    }

    protected static void transmitPlayerCannotProceed(ArrayList<GameListener> listeners, Player player) {
        for (GameListener listener : listeners) {
            listener.onPlayerCannotProceed(player);
        }
    }

    protected static void transmitPlayerEndsTurn(ArrayList<GameListener> listeners, Player player) {
        for (GameListener listener : listeners) {
            listener.onPlayerEndsTurn(player);
        }
    }
}
