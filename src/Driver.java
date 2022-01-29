import SnakesAndLadders.Game;
import SnakesAndLadders.GameInProgressException;
import SnakesAndLadders.GameListener;
import SnakesAndLadders.GameNotStartedException;
import SnakesAndLadders.NotEnoughPlayersException;
import SnakesAndLadders.Player;
import SnakesAndLadders.Square;

public class Driver implements GameListener {
    public void onPlayerStartsTurn(Player player) {
        System.out.println(player + " starts their turn on square " + player.getCurrentSquare() + ".");
    }

    public void onPlayerRollsDice(Player player, int rollResult) {
        System.out.println(player + " rolled a " + rollResult + ".");
    }

    public void onPlayerLandsOnSquare(Player player, Square squareLandedOn) {
        System.out.println(player + " landed on square " + squareLandedOn.getSquareNumber() + ".");
    }

    public void onPlayerClimbsLadder(Player player, Square squareClimbedTo) {
        System.out.println(player + " climbed a ladder to square " + squareClimbedTo.getSquareNumber() + ".");
    }

    public void onPlayerChasedBySnake(Player player, Square squareChasedTo) {
        System.out.println(player + " was chased by a snake to square " + squareChasedTo.getSquareNumber() + ".");
    }

    public void onPlayerCannotProceed(Player player) {
        System.out.println(player + "'s roll was too big to proceed.");
    }

    public void onPlayerEndsTurn(Player player) {
        System.out.println("");
    }

    public void onPlayerWins(Player player) {
        System.out.println(player + " wins!");
    }

    public static void main(String[] args) {
        try {
            Driver driver = new Driver();
            Game game = new Game();
            game.registerListener(driver);
    
            game.addPlayer("Player 1");
            game.addPlayer("Player 2");

            game.start();
    
            for (int i = 0; i < 50; i++) {
                game.takeTurn();
            }
        } catch (NotEnoughPlayersException e) {
            e.printStackTrace();
        } catch (GameNotStartedException e) {
            e.printStackTrace();
        } catch (GameInProgressException e) {
            e.printStackTrace();
        }
    }
}
