import java.util.ArrayList;

public class GameTransmitter {
    public static void transmitPlayerStartsTurn(ArrayList<GameListener> listeners, Player player) {
        for (GameListener listener : listeners) {
            listener.onPlayerStartsTurn(player);
        }
    }

    public static void transmitPlayerRollsDice(ArrayList<GameListener> listeners, Player player, int rollResult) {
        for (GameListener listener : listeners) {
            listener.onPlayerRollsDice(player, rollResult);
        }
    }

    public static void transmitPlayerLandsOnSquare(ArrayList<GameListener> listeners, Player player, Square squareLandedOn) {
        for (GameListener listener : listeners) {
            listener.onPlayerLandsOnSquare(player, squareLandedOn);
        }
    }

    public static void transmitPlayerClimbsLadder(ArrayList<GameListener> listeners, Player player, Square squareClimbedTo) {
        for (GameListener listener : listeners) {
            listener.onPlayerClimbsLadder(player, squareClimbedTo);
        }
    }

    public static void transmitPlayerChasedBySnake(ArrayList<GameListener> listeners, Player player, Square squareChasedTo) {
        for (GameListener listener : listeners) {
            listener.onPlayerChasedBySnake(player, squareChasedTo);
        }
    }

    public static void transmitPlayerCannotProceed(ArrayList<GameListener> listeners, Player player) {
        for (GameListener listener : listeners) {
            listener.onPlayerCannotProceed(player);
        }
    }

    public static void transmitPlayerEndsTurn(ArrayList<GameListener> listeners, Player player) {
        for (GameListener listener : listeners) {
            listener.onPlayerEndsTurn(player);
        }
    }
}
