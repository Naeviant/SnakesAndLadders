package SnakesAndLadders;

public interface GameListener {
    void onPlayerStartsTurn(Player player);
    void onPlayerRollsDice(Player player, int rollResult);
    void onPlayerLandsOnSquare(Player player, Square squareLandedOn);
    void onPlayerClimbsLadder(Player player, Square squareClimbedTo);
    void onPlayerChasedBySnake(Player player, Square squareChasedTo);
    void onPlayerCannotProceed(Player player);
    void onPlayerEndsTurn(Player player);
}
